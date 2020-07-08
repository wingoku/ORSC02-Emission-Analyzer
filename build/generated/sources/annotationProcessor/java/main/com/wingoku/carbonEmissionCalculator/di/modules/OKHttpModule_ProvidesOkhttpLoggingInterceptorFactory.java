package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OKHttpModule_ProvidesOkhttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
  private final OKHttpModule module;

  public OKHttpModule_ProvidesOkhttpLoggingInterceptorFactory(OKHttpModule module) {
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return providesOkhttpLoggingInterceptor(module);
  }

  public static OKHttpModule_ProvidesOkhttpLoggingInterceptorFactory create(OKHttpModule module) {
    return new OKHttpModule_ProvidesOkhttpLoggingInterceptorFactory(module);
  }

  public static HttpLoggingInterceptor providesOkhttpLoggingInterceptor(OKHttpModule instance) {
    return Preconditions.checkNotNull(instance.providesOkhttpLoggingInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
