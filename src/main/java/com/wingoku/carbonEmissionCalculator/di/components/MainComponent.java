package com.wingoku.carbonEmissionCalculator.di.components;

import com.wingoku.carbonEmissionCalculator.Main;
import com.wingoku.carbonEmissionCalculator.di.modules.CarbonEmissionCalculatorModule;
import dagger.Component;

/**
 * Created by Umer on 7/7/2020.
 */

@Component(modules = {CarbonEmissionCalculatorModule.class})
public interface MainComponent {
    void inject(Main main);
}
