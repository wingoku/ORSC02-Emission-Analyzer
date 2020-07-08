package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_ProvidesRxJava2AdapterFactoryFactory implements Factory<RxJava2CallAdapterFactory> {
  private final RetrofitModule module;

  public RetrofitModule_ProvidesRxJava2AdapterFactoryFactory(RetrofitModule module) {
    this.module = module;
  }

  @Override
  public RxJava2CallAdapterFactory get() {
    return providesRxJava2AdapterFactory(module);
  }

  public static RetrofitModule_ProvidesRxJava2AdapterFactoryFactory create(RetrofitModule module) {
    return new RetrofitModule_ProvidesRxJava2AdapterFactoryFactory(module);
  }

  public static RxJava2CallAdapterFactory providesRxJava2AdapterFactory(RetrofitModule instance) {
    return Preconditions.checkNotNull(instance.providesRxJava2AdapterFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
