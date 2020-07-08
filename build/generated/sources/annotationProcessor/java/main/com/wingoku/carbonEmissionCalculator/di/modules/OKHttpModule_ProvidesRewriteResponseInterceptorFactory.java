package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Interceptor;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OKHttpModule_ProvidesRewriteResponseInterceptorFactory implements Factory<Interceptor> {
  private final OKHttpModule module;

  public OKHttpModule_ProvidesRewriteResponseInterceptorFactory(OKHttpModule module) {
    this.module = module;
  }

  @Override
  public Interceptor get() {
    return providesRewriteResponseInterceptor(module);
  }

  public static OKHttpModule_ProvidesRewriteResponseInterceptorFactory create(OKHttpModule module) {
    return new OKHttpModule_ProvidesRewriteResponseInterceptorFactory(module);
  }

  public static Interceptor providesRewriteResponseInterceptor(OKHttpModule instance) {
    return Preconditions.checkNotNull(instance.providesRewriteResponseInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
