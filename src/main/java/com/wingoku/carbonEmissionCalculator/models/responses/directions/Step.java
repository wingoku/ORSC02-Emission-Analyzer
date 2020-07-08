
package com.wingoku.carbonEmissionCalculator.models.responses.directions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Step {

    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("duration")
    @Expose
    private double duration;
    @SerializedName("type")
    @Expose
    private double type;
    @SerializedName("instruction")
    @Expose
    private String instruction;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("way_points")
    @Expose
    private List<Double> wayPoints = null;
    @SerializedName("exit_number")
    @Expose
    private double exitNumber;

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

    public double getType() {
        return type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(List<Double> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public double getExitNumber() {
        return exitNumber;
    }

    public void setExitNumber(double exitNumber) {
        this.exitNumber = exitNumber;
    }

}
