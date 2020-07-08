package com.wingoku.carbonEmissionCalculator.utils;

/**
 * Created by Umer on 7/7/2020.
 */

public class Constants {
    public static final String ORS_TOKEN = System.getenv("ORS_TOKEN");//"5b3ce3597851110001cf62489277d40834e242d487bc675038c1100e";
    public static final String BASE_URL = "http://api.openrouteservice.org/";
    public static final boolean DEBUG_MODE = false;
    public static final String CAR_PROFILE = "driving-car";
    public static final String LOCALITY = "locality";
    public static final String KEY_START_CITY = "startCity";
    public static final String KEY_END_CITY = "endCity";
    public static final String KEY_TRANSPORTATION_TYPE = "transportationType";
    public static final String KILOMETER = "km";
    public static final String c02DataJSON = "{\"small-diesel-car\"  : 142,\n" +
            "\"small-petrol-car\"  : 154,\n" +
            "\"small-plugin-hybrid-car\"  : 73,\n" +
            "\"small-electric-car\"  : 50,\n" +
            "\"medium-diesel-car\"  : 171,\n" +
            "\"medium-petrol-car\"  : 192,\n" +
            "\"medium-plugin-hybrid-car\"  : 110,\n" +
            "\"medium-electric-car\"  : 58,\n" +
            "\"large-diesel-car\"  : 209,\n" +
            "\"large-petrol-car\"  : 282,\n" +
            "\"large-plugin-hybrid-car\"  : 126,\n" +
            "\"large-electric-car\"  : 73,\n" +
            "\"bus\"  : 27,\n" +
            "\"train\"  : 6\n" +
            "}";
}
