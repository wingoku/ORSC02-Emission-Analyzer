package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Cache;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OKHttpModule_ProvidesCacheFactory implements Factory<Cache> {
  private final OKHttpModule module;

  public OKHttpModule_ProvidesCacheFactory(OKHttpModule module) {
    this.module = module;
  }

  @Override
  public Cache get() {
    return providesCache(module);
  }

  public static OKHttpModule_ProvidesCacheFactory create(OKHttpModule module) {
    return new OKHttpModule_ProvidesCacheFactory(module);
  }

  public static Cache providesCache(OKHttpModule instance) {
    return Preconditions.checkNotNull(instance.providesCache(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
