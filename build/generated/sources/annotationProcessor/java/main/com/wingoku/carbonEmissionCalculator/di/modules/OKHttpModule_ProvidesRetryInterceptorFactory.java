package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import org.slf4j.Logger;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OKHttpModule_ProvidesRetryInterceptorFactory implements Factory<Interceptor> {
  private final OKHttpModule module;

  private final Provider<Logger> loggerProvider;

  public OKHttpModule_ProvidesRetryInterceptorFactory(OKHttpModule module,
      Provider<Logger> loggerProvider) {
    this.module = module;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public Interceptor get() {
    return providesRetryInterceptor(module, loggerProvider.get());
  }

  public static OKHttpModule_ProvidesRetryInterceptorFactory create(OKHttpModule module,
      Provider<Logger> loggerProvider) {
    return new OKHttpModule_ProvidesRetryInterceptorFactory(module, loggerProvider);
  }

  public static Interceptor providesRetryInterceptor(OKHttpModule instance, Logger logger) {
    return Preconditions.checkNotNull(instance.providesRetryInterceptor(logger), "Cannot return null from a non-@Nullable @Provides method");
  }
}
