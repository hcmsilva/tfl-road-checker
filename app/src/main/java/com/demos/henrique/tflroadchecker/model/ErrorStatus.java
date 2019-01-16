package com.demos.henrique.tflroadchecker.model;

import com.demos.henrique.tflroadchecker.dto.ErrorStatusDto;

public class ErrorStatus implements Status {

    private final ErrorStatusDto dto;

    public ErrorStatus(ErrorStatusDto dto) {
        this.dto = dto;
    }

    @Override
    public String getDisplayName() {
        return "Unknown: " + dto.getRelativeUri() + " - " + dto.getHttpStatus();
    }

    @Override
    public String getStatus() {
        return "Error Code: " + dto.getHttpStatus();
    }

    @Override
    public String getDescription() {
        return dto.getMessage();
    }

    @Override
    public Boolean isValid() {
        return dto != null &&
                dto.getRelativeUri() != null &&
                dto.getHttpStatus() != null &&
                dto.getMessage() != null;
    }


}
