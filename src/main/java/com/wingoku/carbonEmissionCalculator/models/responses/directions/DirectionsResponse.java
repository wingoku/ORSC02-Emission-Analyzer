
package com.wingoku.carbonEmissionCalculator.models.responses.directions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wingoku.carbonEmissionCalculator.models.responses.Response;

public class DirectionsResponse extends Response {

    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;
    @SerializedName("bbox")
    @Expose
    private List<Double> bbox = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Double> getBbox() {
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
