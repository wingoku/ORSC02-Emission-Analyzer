package com.wingoku.carbonEmissionCalculator.di.modules;

import dagger.Module;
import dagger.Provides;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Umer on 7/7/2020.
 */

@Module
public class LoggerModule {
    @Provides
    public Logger provideLogger() {
        return LoggerFactory.getLogger("C02_Emission_Calculator");
    }
}
