package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OKHttpModule_ProvideOkHttpClientBuilderFactory implements Factory<OkHttpClient.Builder> {
  private final OKHttpModule module;

  public OKHttpModule_ProvideOkHttpClientBuilderFactory(OKHttpModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient.Builder get() {
    return provideOkHttpClientBuilder(module);
  }

  public static OKHttpModule_ProvideOkHttpClientBuilderFactory create(OKHttpModule module) {
    return new OKHttpModule_ProvideOkHttpClientBuilderFactory(module);
  }

  public static OkHttpClient.Builder provideOkHttpClientBuilder(OKHttpModule instance) {
    return Preconditions.checkNotNull(instance.provideOkHttpClientBuilder(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
