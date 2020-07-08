
package com.wingoku.carbonEmissionCalculator.models.responses.distanceOrTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("attribution")
    @Expose
    private String attribution;
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("timestamp")
    @Expose
    private double timestamp;
    @SerializedName("query")
    @Expose
    private Query query;
    @SerializedName("engine")
    @Expose
    private Engine engine;

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
