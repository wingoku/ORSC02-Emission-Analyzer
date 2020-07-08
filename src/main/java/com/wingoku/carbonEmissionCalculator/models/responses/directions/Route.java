
package com.wingoku.carbonEmissionCalculator.models.responses.directions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Route {

    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("segments")
    @Expose
    private List<Segment> segments = null;
    @SerializedName("bbox")
    @Expose
    private List<Double> bbox = null;
    @SerializedName("geometry")
    @Expose
    private String geometry;
    @SerializedName("way_points")
    @Expose
    private List<Double> wayPoints = null;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Double> getBbox() {
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public List<Double> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(List<Double> wayPoints) {
        this.wayPoints = wayPoints;
    }

}
