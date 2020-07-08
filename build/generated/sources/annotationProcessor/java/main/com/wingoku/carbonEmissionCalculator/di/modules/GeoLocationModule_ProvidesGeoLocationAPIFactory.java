package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GeoLocationModule_ProvidesGeoLocationAPIFactory implements Factory<GeolocationAPI> {
  private final GeoLocationModule module;

  private final Provider<Retrofit> retrofitProvider;

  public GeoLocationModule_ProvidesGeoLocationAPIFactory(GeoLocationModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GeolocationAPI get() {
    return providesGeoLocationAPI(module, retrofitProvider.get());
  }

  public static GeoLocationModule_ProvidesGeoLocationAPIFactory create(GeoLocationModule module,
      Provider<Retrofit> retrofitProvider) {
    return new GeoLocationModule_ProvidesGeoLocationAPIFactory(module, retrofitProvider);
  }

  public static GeolocationAPI providesGeoLocationAPI(GeoLocationModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNull(instance.providesGeoLocationAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
  }
}
