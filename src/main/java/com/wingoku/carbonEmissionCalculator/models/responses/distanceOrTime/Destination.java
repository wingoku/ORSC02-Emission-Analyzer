
package com.wingoku.carbonEmissionCalculator.models.responses.distanceOrTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Destination {

    @SerializedName("location")
    @Expose
    private List<Double> location = null;
    @SerializedName("snapped_distance")
    @Expose
    private double snappedDistance;

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public double getSnappedDistance() {
        return snappedDistance;
    }

    public void setSnappedDistance(double snappedDistance) {
        this.snappedDistance = snappedDistance;
    }

}
