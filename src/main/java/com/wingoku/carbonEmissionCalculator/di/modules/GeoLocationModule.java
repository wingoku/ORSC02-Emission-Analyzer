package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Umer on 7/7/2020.
 */

@Module(includes = {RetrofitModule.class})
public class GeoLocationModule {
    @Provides
    public GeolocationAPI providesGeoLocationAPI(Retrofit retrofit) {
        return retrofit.create(GeolocationAPI.class);
    }
}
