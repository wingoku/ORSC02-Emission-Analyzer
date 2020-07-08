package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitBaseUrlModule_ProvidesMarvelAPIUrlFactory implements Factory<String> {
  private final RetrofitBaseUrlModule module;

  public RetrofitBaseUrlModule_ProvidesMarvelAPIUrlFactory(RetrofitBaseUrlModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return providesMarvelAPIUrl(module);
  }

  public static RetrofitBaseUrlModule_ProvidesMarvelAPIUrlFactory create(
      RetrofitBaseUrlModule module) {
    return new RetrofitBaseUrlModule_ProvidesMarvelAPIUrlFactory(module);
  }

  public static String providesMarvelAPIUrl(RetrofitBaseUrlModule instance) {
    return Preconditions.checkNotNull(instance.providesMarvelAPIUrl(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
