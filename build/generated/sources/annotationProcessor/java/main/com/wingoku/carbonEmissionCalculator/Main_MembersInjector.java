package com.wingoku.carbonEmissionCalculator;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Main_MembersInjector implements MembersInjector<Main> {
  private final Provider<CarbonEmissionCalculator> carbonEmissionCalculatorProvider;

  public Main_MembersInjector(Provider<CarbonEmissionCalculator> carbonEmissionCalculatorProvider) {
    this.carbonEmissionCalculatorProvider = carbonEmissionCalculatorProvider;
  }

  public static MembersInjector<Main> create(
      Provider<CarbonEmissionCalculator> carbonEmissionCalculatorProvider) {
    return new Main_MembersInjector(carbonEmissionCalculatorProvider);}

  @Override
  public void injectMembers(Main instance) {
    injectCarbonEmissionCalculator(instance, carbonEmissionCalculatorProvider.get());
  }

  @InjectedFieldSignature("com.wingoku.carbonEmissionCalculator.Main.carbonEmissionCalculator")
  public static void injectCarbonEmissionCalculator(Main instance,
      CarbonEmissionCalculator carbonEmissionCalculator) {
    instance.carbonEmissionCalculator = carbonEmissionCalculator;
  }
}
