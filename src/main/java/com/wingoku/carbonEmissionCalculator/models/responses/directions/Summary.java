
package com.wingoku.carbonEmissionCalculator.models.responses.directions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("duration")
    @Expose
    private double duration;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
