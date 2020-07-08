package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.HashMap;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainModule_ProvidesCommandLineArgumentsFactory implements Factory<HashMap<String, String>> {
  private final MainModule module;

  public MainModule_ProvidesCommandLineArgumentsFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public HashMap<String, String> get() {
    return providesCommandLineArguments(module);
  }

  public static MainModule_ProvidesCommandLineArgumentsFactory create(MainModule module) {
    return new MainModule_ProvidesCommandLineArgumentsFactory(module);
  }

  public static HashMap<String, String> providesCommandLineArguments(MainModule instance) {
    return Preconditions.checkNotNull(instance.providesCommandLineArguments(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
