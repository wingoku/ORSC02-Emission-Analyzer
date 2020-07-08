package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.CarbonEmissionCalculator;
import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import dagger.Module;
import dagger.Provides;
import org.slf4j.Logger;

import java.util.HashMap;

/**
 * Created by Umer on 7/7/2020.
 */

@Module(includes = {MainModule.class, LoggerModule.class, GeoLocationModule.class})
public class CarbonEmissionCalculatorModule {

    @Provides
    public CarbonEmissionCalculator providesCarbonEmissionCalculator(HashMap<String, String> commandLineArgsMap, Logger logger, GeolocationAPI geolocationAPI) {
        return new CarbonEmissionCalculator(commandLineArgsMap, logger, geolocationAPI);
    }
}
