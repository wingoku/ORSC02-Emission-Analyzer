package com.wingoku.carbonEmissionCalculator.utils;

import com.google.gson.Gson;

/**
 * Created by Umer on 7/7/2020.
 */

public class Utils {
    private static Gson gson = null;

    public static Gson getGson() {
        if(gson == null)
            gson = new Gson();
        return gson;
    }
}
