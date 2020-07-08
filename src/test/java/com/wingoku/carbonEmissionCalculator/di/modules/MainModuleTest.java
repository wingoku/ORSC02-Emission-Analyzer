package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.utils.Constants;
import org.junit.After;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainModuleTest {
    private MainModule mainModule;
    private HashMap<String, String> map;

    @Test
    public void testValidCmdArgsWithEqualDelimiter() {
        mainModule = new MainModule(new String[] {"--start=Hamburg", "--end=Berlin", "--transportation-method=medium-diesel-car"});
        map = mainModule.providesCommandLineArguments();
    }

    @Test
    public void testValidCmdArgsWithSpaceDelimiter() {
        mainModule = new MainModule(new String[] {"--start", "Hamburg", "--end", "Berlin", "--transportation-method", "medium-diesel-car"});
        map = mainModule.providesCommandLineArguments();
    }

    @Test
    public void testValidCmdArgsWithSpaceDelimiterAndReversedOrder() {
        mainModule = new MainModule(new String[] {"--transportation-method", "medium-diesel-car", "--end", "Berlin", "--start", "Hamburg"});
        map = mainModule.providesCommandLineArguments();
    }

    @Test
    public void testMissingCmdArgs() {
        mainModule = new MainModule(new String[] {"--start", "Hamburg", "--end", "--transportation-method=medium-diesel-car"});
        map = mainModule.providesCommandLineArguments();
    }

    @After
    public void validateArgsMap() {
        System.out.println("commandLine arguments map: "+ map.toString());
        assertEquals(map.size(), 3);
        assertEquals(map.get(Constants.KEY_START_CITY), "Hamburg");
        assertEquals(map.get(Constants.KEY_END_CITY), "Berlin");
        assertEquals(map.get(Constants.KEY_TRANSPORTATION_TYPE), "medium-diesel-car");
    }
}
