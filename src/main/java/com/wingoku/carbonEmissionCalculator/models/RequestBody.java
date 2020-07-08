package com.wingoku.carbonEmissionCalculator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Umer on 7/7/2020.
 */

public class RequestBody {
    @SerializedName("coordinates")
    @Expose
    private List<List<Double>> coordinates = null;

    @SerializedName("units")
    @Expose
    private String unit = null;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }
}
