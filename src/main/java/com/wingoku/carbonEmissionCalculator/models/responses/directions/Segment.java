
package com.wingoku.carbonEmissionCalculator.models.responses.directions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Segment {

    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("duration")
    @Expose
    private double duration;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;

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

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

}
