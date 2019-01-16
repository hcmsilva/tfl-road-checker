package com.demos.henrique.tflroadchecker.model;

import com.demos.henrique.tflroadchecker.dto.RoadStatusDto;

public class RoadStatus implements Status {

    private final RoadStatusDto dto;

    public RoadStatus(RoadStatusDto dto) {
        this.dto = dto;
    }

    @Override
    public String getDisplayName() {
        return dto.getDisplayName();
    }

    @Override
    public String getStatus() {
        return dto.getStatusSeverity();
    }

    @Override
    public String getDescription() {
        return dto.getStatusSeverityDescription();
    }

    @Override
    public Boolean isValid() {
        return dto != null &&
                dto.getDisplayName() != null &&
                dto.getStatusSeverity() != null &&
                dto.getStatusSeverityDescription() != null;
    }
}
