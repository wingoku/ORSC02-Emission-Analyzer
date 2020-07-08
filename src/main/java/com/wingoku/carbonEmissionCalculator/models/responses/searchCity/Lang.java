
package com.wingoku.carbonEmissionCalculator.models.responses.searchCity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lang {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iso6391")
    @Expose
    private String iso6391;
    @SerializedName("iso6393")
    @Expose
    private String iso6393;
    @SerializedName("defaulted")
    @Expose
    private boolean defaulted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getIso6393() {
        return iso6393;
    }

    public void setIso6393(String iso6393) {
        this.iso6393 = iso6393;
    }

    public boolean isDefaulted() {
        return defaulted;
    }

    public void setDefaulted(boolean defaulted) {
        this.defaulted = defaulted;
    }

}
