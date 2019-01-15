package com.demos.henrique.tflroadchecker.dto;

import com.google.gson.annotations.SerializedName;

public class RoadStatusDto {

    @SerializedName("statusSeverityDescription")
    private String statusSeverityDescription;

    @SerializedName("envelope")
    private String envelope;

    @SerializedName("displayName")
    private String displayName;

    @SerializedName("statusSeverity")
    private String statusSeverity;

    @SerializedName("bounds")
    private String bounds;

    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    @SerializedName("$type")
    private String type;

    public void setStatusSeverityDescription(String statusSeverityDescription) {
        this.statusSeverityDescription = statusSeverityDescription;
    }

    public String getStatusSeverityDescription() {
        return statusSeverityDescription;
    }

    public void setEnvelope(String envelope) {
        this.envelope = envelope;
    }

    public String getEnvelope() {
        return envelope;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setStatusSeverity(String statusSeverity) {
        this.statusSeverity = statusSeverity;
    }

    public String getStatusSeverity() {
        return statusSeverity;
    }

    public void setBounds(String bounds) {
        this.bounds = bounds;
    }

    public String getBounds() {
        return bounds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return
                "RoadStatusDto{" +
                        "statusSeverityDescription = '" + statusSeverityDescription + '\'' +
                        ",envelope = '" + envelope + '\'' +
                        ",displayName = '" + displayName + '\'' +
                        ",statusSeverity = '" + statusSeverity + '\'' +
                        ",bounds = '" + bounds + '\'' +
                        ",id = '" + id + '\'' +
                        ",url = '" + url + '\'' +
                        ",$type = '" + type + '\'' +
                        "}";
    }
}