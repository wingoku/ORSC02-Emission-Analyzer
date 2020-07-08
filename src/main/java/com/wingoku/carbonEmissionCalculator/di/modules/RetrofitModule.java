package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Umer on 7/7/2020.
 */

@Module(includes = {OKHttpModule.class, RetrofitBaseUrlModule.class})
public class RetrofitModule {

    @Provides
    public Retrofit providesRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2AdapterFactory, String baseUrl) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(rxJava2AdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    public GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    public RxJava2CallAdapterFactory providesRxJava2AdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }
}