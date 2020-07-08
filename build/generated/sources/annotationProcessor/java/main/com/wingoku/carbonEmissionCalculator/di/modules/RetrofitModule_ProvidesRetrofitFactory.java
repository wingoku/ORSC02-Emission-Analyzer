package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_ProvidesRetrofitFactory implements Factory<Retrofit> {
  private final RetrofitModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<GsonConverterFactory> gsonConverterFactoryProvider;

  private final Provider<RxJava2CallAdapterFactory> rxJava2AdapterFactoryProvider;

  private final Provider<String> baseUrlProvider;

  public RetrofitModule_ProvidesRetrofitFactory(RetrofitModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider,
      Provider<RxJava2CallAdapterFactory> rxJava2AdapterFactoryProvider,
      Provider<String> baseUrlProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.gsonConverterFactoryProvider = gsonConverterFactoryProvider;
    this.rxJava2AdapterFactoryProvider = rxJava2AdapterFactoryProvider;
    this.baseUrlProvider = baseUrlProvider;
  }

  @Override
  public Retrofit get() {
    return providesRetrofit(module, okHttpClientProvider.get(), gsonConverterFactoryProvider.get(), rxJava2AdapterFactoryProvider.get(), baseUrlProvider.get());
  }

  public static RetrofitModule_ProvidesRetrofitFactory create(RetrofitModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider,
      Provider<RxJava2CallAdapterFactory> rxJava2AdapterFactoryProvider,
      Provider<String> baseUrlProvider) {
    return new RetrofitModule_ProvidesRetrofitFactory(module, okHttpClientProvider, gsonConverterFactoryProvider, rxJava2AdapterFactoryProvider, baseUrlProvider);
  }

  public static Retrofit providesRetrofit(RetrofitModule instance, OkHttpClient okHttpClient,
      GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2AdapterFactory,
      String baseUrl) {
    return Preconditions.checkNotNull(instance.providesRetrofit(okHttpClient, gsonConverterFactory, rxJava2AdapterFactory, baseUrl), "Cannot return null from a non-@Nullable @Provides method");
  }
}
