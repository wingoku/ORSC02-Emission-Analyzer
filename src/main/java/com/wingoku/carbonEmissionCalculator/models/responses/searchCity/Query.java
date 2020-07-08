
package com.wingoku.carbonEmissionCalculator.models.responses.searchCity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Query {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("size")
    @Expose
    private double size;
    @SerializedName("layers")
    @Expose
    private List<String> layers = null;
    @SerializedName("private")
    @Expose
    private boolean _private;
    @SerializedName("lang")
    @Expose
    private Lang lang;
    @SerializedName("querySize")
    @Expose
    private double querySize;
    @SerializedName("parser")
    @Expose
    private String parser;
    @SerializedName("parsed_text")
    @Expose
    private ParsedText parsedText;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public List<String> getLayers() {
        return layers;
    }

    public void setLayers(List<String> layers) {
        this.layers = layers;
    }

    public boolean isPrivate() {
        return _private;
    }

    public void setPrivate(boolean _private) {
        this._private = _private;
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public double getQuerySize() {
        return querySize;
    }

    public void setQuerySize(double querySize) {
        this.querySize = querySize;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public ParsedText getParsedText() {
        return parsedText;
    }

    public void setParsedText(ParsedText parsedText) {
        this.parsedText = parsedText;
    }

}
