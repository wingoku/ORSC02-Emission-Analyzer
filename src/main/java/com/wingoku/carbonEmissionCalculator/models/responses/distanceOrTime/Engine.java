
package com.wingoku.carbonEmissionCalculator.models.responses.distanceOrTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Engine {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("build_date")
    @Expose
    private String buildDate;
    @SerializedName("graph_date")
    @Expose
    private String graphDate;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getGraphDate() {
        return graphDate;
    }

    public void setGraphDate(String graphDate) {
        this.graphDate = graphDate;
    }

}
