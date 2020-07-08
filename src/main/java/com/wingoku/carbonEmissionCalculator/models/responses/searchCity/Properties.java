
package com.wingoku.carbonEmissionCalculator.models.responses.searchCity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("gid")
    @Expose
    private String gid;
    @SerializedName("layer")
    @Expose
    private String layer;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("source_id")
    @Expose
    private String sourceId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("confidence")
    @Expose
    private double confidence;
    @SerializedName("match_type")
    @Expose
    private String matchType;
    @SerializedName("accuracy")
    @Expose
    private String accuracy;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country_gid")
    @Expose
    private String countryGid;
    @SerializedName("country_a")
    @Expose
    private String countryA;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("region_gid")
    @Expose
    private String regionGid;
    @SerializedName("region_a")
    @Expose
    private String regionA;
    @SerializedName("macrocounty")
    @Expose
    private String macrocounty;
    @SerializedName("macrocounty_gid")
    @Expose
    private String macrocountyGid;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("county_gid")
    @Expose
    private String countyGid;
    @SerializedName("county_a")
    @Expose
    private String countyA;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("locality_gid")
    @Expose
    private String localityGid;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("continent_gid")
    @Expose
    private String continentGid;
    @SerializedName("label")
    @Expose
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryGid() {
        return countryGid;
    }

    public void setCountryGid(String countryGid) {
        this.countryGid = countryGid;
    }

    public String getCountryA() {
        return countryA;
    }

    public void setCountryA(String countryA) {
        this.countryA = countryA;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionGid() {
        return regionGid;
    }

    public void setRegionGid(String regionGid) {
        this.regionGid = regionGid;
    }

    public String getRegionA() {
        return regionA;
    }

    public void setRegionA(String regionA) {
        this.regionA = regionA;
    }

    public String getMacrocounty() {
        return macrocounty;
    }

    public void setMacrocounty(String macrocounty) {
        this.macrocounty = macrocounty;
    }

    public String getMacrocountyGid() {
        return macrocountyGid;
    }

    public void setMacrocountyGid(String macrocountyGid) {
        this.macrocountyGid = macrocountyGid;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyGid() {
        return countyGid;
    }

    public void setCountyGid(String countyGid) {
        this.countyGid = countyGid;
    }

    public String getCountyA() {
        return countyA;
    }

    public void setCountyA(String countyA) {
        this.countyA = countyA;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLocalityGid() {
        return localityGid;
    }

    public void setLocalityGid(String localityGid) {
        this.localityGid = localityGid;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinentGid() {
        return continentGid;
    }

    public void setContinentGid(String continentGid) {
        this.continentGid = continentGid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
