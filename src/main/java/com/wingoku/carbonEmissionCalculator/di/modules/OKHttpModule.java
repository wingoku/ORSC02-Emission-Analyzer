package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.utils.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;

import javax.inject.Named;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Umer on 7/7/2020.
 */

@Module (includes = LoggerModule.class)
public class OKHttpModule {

    private static final int REQUEST_RETRIES = 1;
    private static final int CONNECTION_TIME_OUT = 25;

    @Provides
    public OkHttpClient providesOkHttpClient(Logger logger, OkHttpClient.Builder builder, HttpLoggingInterceptor okhttpLoggingInterceptor, Cache cache, @Named("RewriteResponseInterceptor") Interceptor rewriteResponseInterceptor, @Named("RetryInterceptor") Interceptor retriesInterceptor) {
        builder.cache(cache);
        builder.addInterceptor(retriesInterceptor);
        builder.addInterceptor(rewriteResponseInterceptor);

        if(Constants.DEBUG_MODE) {
            builder.addInterceptor(okhttpLoggingInterceptor);
        }

        return builder.build();
    }

    @Provides
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient().newBuilder();
        okhttpClientBuilder.connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS);
        return okhttpClientBuilder;
    }

    @Provides
    public Cache providesCache() {
        File httpCacheDirectory = new File("geolocation_responses");
        int cacheSize = 100 * 1024 * 1024; // 100 MB
        return new Cache(httpCacheDirectory, cacheSize);
    }

    //logging OKHTTP internal handling logs
    @Provides
    public HttpLoggingInterceptor providesOkhttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC).setLevel
                (HttpLoggingInterceptor.Level.BODY).setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return interceptor;
    }

    @Provides
    @Named("RewriteResponseInterceptor")
    public Interceptor providesRewriteResponseInterceptor() {
        return chain -> {
            Response originalResponse = chain.proceed(chain.request());
            String cacheControl = originalResponse.header("Cache-Control");
            if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                    cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0") || cacheControl.contains("only-if-cached")) {
                return originalResponse.newBuilder()
                        .removeHeader("must-revalidate")
                        .removeHeader("Pragma")
                        .removeHeader("Connection")
                        .removeHeader("Transfer-Encoding")
                        .removeHeader("keep-alive")
                        .removeHeader("Date")
                        .header("Cache-Control", "public, max-age=" + 500000)
                        .build();
            } else {
                return originalResponse;
            }
        };
    }

    @Provides
    @Named("RetryInterceptor")
    public Interceptor providesRetryInterceptor(Logger logger) {
        return chain -> {
            Response response = chain.proceed(chain.request());
            int retries = 0;
            try {
                //if server response isn't successful, contact the server for proper response REQUEST_RETRIES times
                while (!response.isSuccessful() && retries < REQUEST_RETRIES) {
                    logger.error("RESPONSE_ERROR: response message: {} response Code: {}", response.message(), response.code());
                    logger.error("RESPONSE_ERROR: response body: {}", response.body().string());

                    response = chain.proceed(chain.request());
                    retries++;
                }
            }
            catch (Exception e) {
                //close the network call here
                response.body().close();
            }
            return response;
        };
    }
}