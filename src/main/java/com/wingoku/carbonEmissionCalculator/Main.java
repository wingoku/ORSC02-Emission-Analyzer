package com.wingoku.carbonEmissionCalculator;

import com.wingoku.carbonEmissionCalculator.di.components.DaggerMainComponent;
import com.wingoku.carbonEmissionCalculator.di.components.MainComponent;
import com.wingoku.carbonEmissionCalculator.di.modules.MainModule;

import javax.inject.Inject;

/**
 * Created by Umer on 7/7/2020.
 */

public class Main {
    @Inject
    CarbonEmissionCalculator carbonEmissionCalculator;

    public static void main(String[] args) {
        Main main = new Main();
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(args)).build();
        component.inject(main);
        main.init();
    }

    public void init() {
        carbonEmissionCalculator.calculate();
    }
}