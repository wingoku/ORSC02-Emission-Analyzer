package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_ProvidesGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {
  private final RetrofitModule module;

  public RetrofitModule_ProvidesGsonConverterFactoryFactory(RetrofitModule module) {
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return providesGsonConverterFactory(module);
  }

  public static RetrofitModule_ProvidesGsonConverterFactoryFactory create(RetrofitModule module) {
    return new RetrofitModule_ProvidesGsonConverterFactoryFactory(module);
  }

  public static GsonConverterFactory providesGsonConverterFactory(RetrofitModule instance) {
    return Preconditions.checkNotNull(instance.providesGsonConverterFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
