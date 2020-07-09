package com.wingoku.carbonEmissionCalculator.di.modules;

import com.wingoku.carbonEmissionCalculator.utils.Constants;
import dagger.Module;
import dagger.Provides;

import java.util.HashMap;

/**
 * Created by Umer on 7/7/2020.
 */

@Module
public class MainModule {
    private HashMap<String, String> commandLineArgsMap = null;
    private RuntimeException runtimeException = new RuntimeException("Please provide all the necessary arguments like Start City, End City & Transportation Type");
    
    public MainModule(String[] args) {
        commandLineArgsMap = new HashMap<>();
        createCommandLineArgsMap(args);
    }

    private void createCommandLineArgsMap(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if(args[i].contains("--start")) {
                String cityName = "";
                if(args[i].contains("=")) {
                    cityName = args[i].split("=")[1];
                }
                else {
                    if(i+1 >= args.length)
                        throw runtimeException;

                    cityName = args[i + 1];
                    i++;
                }

                cityName = cityName.replace("\"", "");
                cityName = cityName.replace("'", "");
                commandLineArgsMap.put(Constants.KEY_START_CITY, cityName);
            }
            else if(args[i].contains("--end")) {
                String cityName = "";
                if(args[i].contains("=")) {
                    cityName = args[i].split("=")[1];
                }
                else {
                    if(i+1 >= args.length)
                        throw runtimeException;

                    cityName = args[i + 1];
                    i++;
                }

                cityName = cityName.replace("\"", "");
                cityName = cityName.replace("'", "");
                commandLineArgsMap.put(Constants.KEY_END_CITY, cityName);
            }
            else if(args[i].contains("--transportation-method")) {
                String transportationMethod = "";
                if(args[i].contains("=")) {
                    transportationMethod = args[i].split("=")[1];
                }
                else {
                    if(i+1 >= args.length)
                        throw runtimeException;

                    transportationMethod = args[i + 1];
                    i++;
                }

                transportationMethod = transportationMethod.replace("\"", "");
                transportationMethod = transportationMethod.replace("'", "");
                commandLineArgsMap.put(Constants.KEY_TRANSPORTATION_TYPE, transportationMethod);
            }
        }

        validate();
    }
    
    private void validate() {
        if(commandLineArgsMap.size() < 3)
            throw runtimeException;
        
        if(commandLineArgsMap.get(Constants.KEY_START_CITY) == null || commandLineArgsMap.get(Constants.KEY_END_CITY).isEmpty()
        ||commandLineArgsMap.get(Constants.KEY_END_CITY) == null || commandLineArgsMap.get(Constants.KEY_END_CITY).isEmpty()
        ||commandLineArgsMap.get(Constants.KEY_TRANSPORTATION_TYPE) == null || commandLineArgsMap.get(Constants.KEY_TRANSPORTATION_TYPE).isEmpty())
            throw runtimeException;
    }
    
    @Provides
    public HashMap<String, String> providesCommandLineArguments() {
        return commandLineArgsMap;
    }
}
