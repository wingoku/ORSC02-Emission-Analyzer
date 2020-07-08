
package com.wingoku.carbonEmissionCalculator.models.responses.searchCity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParsedText {

    @SerializedName("city")
    @Expose
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
