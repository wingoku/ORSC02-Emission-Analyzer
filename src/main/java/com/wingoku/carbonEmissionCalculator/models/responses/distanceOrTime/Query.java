
package com.wingoku.carbonEmissionCalculator.models.responses.distanceOrTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Query {

    @SerializedName("locations")
    @Expose
    private List<List<Double>> locations = null;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("responseType")
    @Expose
    private String responseType;

    public List<List<Double>> getLocations() {
        return locations;
    }

    public void setLocations(List<List<Double>> locations) {
        this.locations = locations;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

}
