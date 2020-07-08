
package com.wingoku.carbonEmissionCalculator.models.responses.searchCity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wingoku.carbonEmissionCalculator.models.responses.Response;

public class SearchCityResponse extends Response {

    @SerializedName("geocoding")
    @Expose
    private Geocoding geocoding;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("bbox")
    @Expose
    private List<Double> bbox = null;

    public Geocoding getGeocoding() {
        return geocoding;
    }

    public void setGeocoding(Geocoding geocoding) {
        this.geocoding = geocoding;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Double> getBbox() {
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

}
