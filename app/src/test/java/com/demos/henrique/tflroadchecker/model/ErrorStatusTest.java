package com.demos.henrique.tflroadchecker.model;

import com.demos.henrique.tflroadchecker.dto.ErrorStatusDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ErrorStatusTest {

    ErrorStatus errorStatus;
    ErrorStatusDto mockErrorStatusDto = mock(ErrorStatusDto.class);
    String validStr = "valid";

    @Before
    public void setup() {

        errorStatus = new ErrorStatus(mockErrorStatusDto);
    }

    @Test
    public void whenValidDtoDependenciesInjectedIsValidSuccess() {
        when(mockErrorStatusDto.getRelativeUri()).thenReturn(validStr);
        when(mockErrorStatusDto.getHttpStatus()).thenReturn(validStr);
        when(mockErrorStatusDto.getMessage()).thenReturn(validStr);

        boolean expectedResult = true;
        assertEquals(expectedResult, errorStatus.isValid());
    }

    @Test
    public void whenInvalidUriIsValidFalse() {
        when(mockErrorStatusDto.getRelativeUri()).thenReturn(null);
        when(mockErrorStatusDto.getHttpStatus()).thenReturn(validStr);
        when(mockErrorStatusDto.getMessage()).thenReturn(validStr);

        boolean expectedResult = false;
        assertEquals(expectedResult, errorStatus.isValid());
    }

    @Test
    public void whenInvalidHttpStatusIsValidFalse() {
        when(mockErrorStatusDto.getRelativeUri()).thenReturn(validStr);
        when(mockErrorStatusDto.getHttpStatus()).thenReturn(null);
        when(mockErrorStatusDto.getMessage()).thenReturn(validStr);

        boolean expectedResult = false;
        assertEquals(expectedResult, errorStatus.isValid());
    }

    @Test
    public void whenInvalidMessageIsValidFalse() {
        when(mockErrorStatusDto.getRelativeUri()).thenReturn(validStr);
        when(mockErrorStatusDto.getHttpStatus()).thenReturn(validStr);
        when(mockErrorStatusDto.getMessage()).thenReturn(null);

        boolean expectedResult = false;
        assertEquals(expectedResult, errorStatus.isValid());
    }
}