package com.demos.henrique.tflroadchecker.dto;

import com.google.gson.annotations.SerializedName;

public class ErrorStatusDto {

    @SerializedName("exceptionType")
    private String exceptionType;

    @SerializedName("httpStatus")
    private String httpStatus;

    @SerializedName("timestampUtc")
    private String timestampUtc;

    @SerializedName("message")
    private String message;

    @SerializedName("$type")
    private String type;

    @SerializedName("httpStatusCode")
    private int httpStatusCode;

    @SerializedName("relativeUri")
    private String relativeUri;

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setTimestampUtc(String timestampUtc) {
        this.timestampUtc = timestampUtc;
    }

    public String getTimestampUtc() {
        return timestampUtc;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setRelativeUri(String relativeUri) {
        this.relativeUri = relativeUri;
    }

    public String getRelativeUri() {
        return relativeUri;
    }

    @Override
    public String toString() {
        return
                "ErrorStatusDto{" +
                        "exceptionType = '" + exceptionType + '\'' +
                        ",httpStatus = '" + httpStatus + '\'' +
                        ",timestampUtc = '" + timestampUtc + '\'' +
                        ",message = '" + message + '\'' +
                        ",$type = '" + type + '\'' +
                        ",httpStatusCode = '" + httpStatusCode + '\'' +
                        ",relativeUri = '" + relativeUri + '\'' +
                        "}";
    }
}