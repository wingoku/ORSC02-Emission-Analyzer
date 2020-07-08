package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import org.slf4j.Logger;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoggerModule_ProvideLoggerFactory implements Factory<Logger> {
  private final LoggerModule module;

  public LoggerModule_ProvideLoggerFactory(LoggerModule module) {
    this.module = module;
  }

  @Override
  public Logger get() {
    return provideLogger(module);
  }

  public static LoggerModule_ProvideLoggerFactory create(LoggerModule module) {
    return new LoggerModule_ProvideLoggerFactory(module);
  }

  public static Logger provideLogger(LoggerModule instance) {
    return Preconditions.checkNotNull(instance.provideLogger(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
