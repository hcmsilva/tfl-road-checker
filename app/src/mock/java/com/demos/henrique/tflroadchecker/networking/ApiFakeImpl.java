package com.demos.henrique.tflroadchecker.networking;

import com.demos.henrique.tflroadchecker.dto.ErrorStatusDto;
import com.demos.henrique.tflroadchecker.dto.RoadStatusDto;
import com.demos.henrique.tflroadchecker.model.ErrorStatus;
import com.demos.henrique.tflroadchecker.model.RoadStatus;
import com.demos.henrique.tflroadchecker.model.Status;

public class ApiFakeImpl implements DataContract {

    private boolean sendErrorMock = false;

    @Override
    public void getTfLFeed(DataReceiver<Status> statusDataReceiver, String roadId) {
        statusDataReceiver.receiveDataCallback(MockResponseGenerator.getMockRoadStatus(sendErrorMock));
        sendErrorMock = !sendErrorMock;
    }


    public static class MockResponseGenerator {
        public static Status getMockRoadStatus(boolean isError) {

            if (!isError) {
                RoadStatusDto mockDto = new RoadStatusDto();
                mockDto.setDisplayName("Mock Road 9999");
                mockDto.setStatusSeverity("Super mocked");
                mockDto.setStatusSeverityDescription("I describe myself as a mock");
                return new RoadStatus(mockDto);
            } else {
                ErrorStatusDto mockError = new ErrorStatusDto();
                mockError.setHttpStatusCode(404);
                mockError.setRelativeUri("/Road/Mock");
                mockError.setHttpStatus("mock road cannot be found");
                mockError.setMessage("Made up mock error message");
                return new ErrorStatus(mockError);
            }
        }
    }
}
