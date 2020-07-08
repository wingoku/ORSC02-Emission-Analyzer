package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OKHttpModule_ProvidesOkHttpClientFactory implements Factory<OkHttpClient> {
  private final OKHttpModule module;

  private final Provider<Logger> loggerProvider;

  private final Provider<OkHttpClient.Builder> builderProvider;

  private final Provider<HttpLoggingInterceptor> okhttpLoggingInterceptorProvider;

  private final Provider<Cache> cacheProvider;

  private final Provider<Interceptor> rewriteResponseInterceptorProvider;

  private final Provider<Interceptor> retriesInterceptorProvider;

  public OKHttpModule_ProvidesOkHttpClientFactory(OKHttpModule module,
      Provider<Logger> loggerProvider, Provider<OkHttpClient.Builder> builderProvider,
      Provider<HttpLoggingInterceptor> okhttpLoggingInterceptorProvider,
      Provider<Cache> cacheProvider, Provider<Interceptor> rewriteResponseInterceptorProvider,
      Provider<Interceptor> retriesInterceptorProvider) {
    this.module = module;
    this.loggerProvider = loggerProvider;
    this.builderProvider = builderProvider;
    this.okhttpLoggingInterceptorProvider = okhttpLoggingInterceptorProvider;
    this.cacheProvider = cacheProvider;
    this.rewriteResponseInterceptorProvider = rewriteResponseInterceptorProvider;
    this.retriesInterceptorProvider = retriesInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return providesOkHttpClient(module, loggerProvider.get(), builderProvider.get(), okhttpLoggingInterceptorProvider.get(), cacheProvider.get(), rewriteResponseInterceptorProvider.get(), retriesInterceptorProvider.get());
  }

  public static OKHttpModule_ProvidesOkHttpClientFactory create(OKHttpModule module,
      Provider<Logger> loggerProvider, Provider<OkHttpClient.Builder> builderProvider,
      Provider<HttpLoggingInterceptor> okhttpLoggingInterceptorProvider,
      Provider<Cache> cacheProvider, Provider<Interceptor> rewriteResponseInterceptorProvider,
      Provider<Interceptor> retriesInterceptorProvider) {
    return new OKHttpModule_ProvidesOkHttpClientFactory(module, loggerProvider, builderProvider, okhttpLoggingInterceptorProvider, cacheProvider, rewriteResponseInterceptorProvider, retriesInterceptorProvider);
  }

  public static OkHttpClient providesOkHttpClient(OKHttpModule instance, Logger logger,
      OkHttpClient.Builder builder, HttpLoggingInterceptor okhttpLoggingInterceptor, Cache cache,
      Interceptor rewriteResponseInterceptor, Interceptor retriesInterceptor) {
    return Preconditions.checkNotNull(instance.providesOkHttpClient(logger, builder, okhttpLoggingInterceptor, cache, rewriteResponseInterceptor, retriesInterceptor), "Cannot return null from a non-@Nullable @Provides method");
  }
}
