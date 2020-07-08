package com.wingoku.carbonEmissionCalculator.di.modules;
import com.wingoku.carbonEmissionCalculator.utils.Constants;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Umer on 7/7/2020.
 */

@Module
public class RetrofitBaseUrlModule {

    @Provides
    public String providesMarvelAPIUrl() {
        return Constants.BASE_URL;
    }
}
