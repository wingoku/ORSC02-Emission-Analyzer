package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.CarbonEmissionCalculator;
import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.HashMap;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.slf4j.Logger;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CarbonEmissionCalculatorModule_ProvidesCarbonEmissionCalculatorFactory implements Factory<CarbonEmissionCalculator> {
  private final CarbonEmissionCalculatorModule module;

  private final Provider<HashMap<String, String>> commandLineArgsMapProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<GeolocationAPI> geolocationAPIProvider;

  public CarbonEmissionCalculatorModule_ProvidesCarbonEmissionCalculatorFactory(
      CarbonEmissionCalculatorModule module,
      Provider<HashMap<String, String>> commandLineArgsMapProvider, Provider<Logger> loggerProvider,
      Provider<GeolocationAPI> geolocationAPIProvider) {
    this.module = module;
    this.commandLineArgsMapProvider = commandLineArgsMapProvider;
    this.loggerProvider = loggerProvider;
    this.geolocationAPIProvider = geolocationAPIProvider;
  }

  @Override
  public CarbonEmissionCalculator get() {
    return providesCarbonEmissionCalculator(module, commandLineArgsMapProvider.get(), loggerProvider.get(), geolocationAPIProvider.get());
  }

  public static CarbonEmissionCalculatorModule_ProvidesCarbonEmissionCalculatorFactory create(
      CarbonEmissionCalculatorModule module,
      Provider<HashMap<String, String>> commandLineArgsMapProvider, Provider<Logger> loggerProvider,
      Provider<GeolocationAPI> geolocationAPIProvider) {
    return new CarbonEmissionCalculatorModule_ProvidesCarbonEmissionCalculatorFactory(module, commandLineArgsMapProvider, loggerProvider, geolocationAPIProvider);
  }

  public static CarbonEmissionCalculator providesCarbonEmissionCalculator(
      CarbonEmissionCalculatorModule instance, HashMap<String, String> commandLineArgsMap,
      Logger logger, GeolocationAPI geolocationAPI) {
    return Preconditions.checkNotNull(instance.providesCarbonEmissionCalculator(commandLineArgsMap, logger, geolocationAPI), "Cannot return null from a non-@Nullable @Provides method");
  }
}
