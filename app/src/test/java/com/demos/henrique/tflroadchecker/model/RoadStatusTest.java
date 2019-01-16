package com.demos.henrique.tflroadchecker.model;

import com.demos.henrique.tflroadchecker.dto.RoadStatusDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoadStatusTest {

    RoadStatus roadStatus;
    RoadStatusDto mockRoadStatusDto = mock(RoadStatusDto.class);
    String validStr = "valid";

    @Before
    public void setup() {

        roadStatus = new RoadStatus(mockRoadStatusDto);
    }

    @Test
    public void whenValidDtoDependencyIsInjectedIsValidSuccess() {
        when(mockRoadStatusDto.getDisplayName()).thenReturn(validStr);
        when(mockRoadStatusDto.getStatusSeverity()).thenReturn(validStr);
        when(mockRoadStatusDto.getStatusSeverityDescription()).thenReturn(validStr);

        boolean expectedResult = true;
        assertEquals(expectedResult, roadStatus.isValid());
    }

    @Test
    public void whenInvalidDisplayNameIsValidFalse() {
        when(mockRoadStatusDto.getDisplayName()).thenReturn(null);
        when(mockRoadStatusDto.getStatusSeverity()).thenReturn(validStr);
        when(mockRoadStatusDto.getStatusSeverityDescription()).thenReturn(validStr);

        boolean expectedResult = false;
        assertEquals(expectedResult, roadStatus.isValid());
    }

    @Test
    public void whenInvalidStatusSeverityIsValidFalse() {
        when(mockRoadStatusDto.getDisplayName()).thenReturn(validStr);
        when(mockRoadStatusDto.getStatusSeverity()).thenReturn(null);
        when(mockRoadStatusDto.getStatusSeverityDescription()).thenReturn(validStr);

        boolean expectedResult = false;
        assertEquals(expectedResult, roadStatus.isValid());
    }

    @Test
    public void whenInvalidStatusSeverityDescriptionIsValidFalse() {
        when(mockRoadStatusDto.getDisplayName()).thenReturn(validStr);
        when(mockRoadStatusDto.getStatusSeverity()).thenReturn(validStr);
        when(mockRoadStatusDto.getStatusSeverityDescription()).thenReturn(null);

        boolean expectedResult = false;
        assertEquals(expectedResult, roadStatus.isValid());
    }
}