package com.demos.henrique.tflroadchecker.simpleroadchecker;

import com.demos.henrique.tflroadchecker.model.Status;
import com.demos.henrique.tflroadchecker.networking.DataContract;
import com.demos.henrique.tflroadchecker.networking.DataReceiver;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerPresenterContract;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerViewContract;

public class RoadCheckerPresenter implements SimpleCheckerPresenterContract, DataReceiver<Status> {

    private final SimpleCheckerViewContract view;
    private final DataContract apiClient;


    public RoadCheckerPresenter(SimpleCheckerViewContract viewContract, DataContract apiClient) {
        view = viewContract;
        this.apiClient = apiClient;
    }

    @Override
    public void getRoadStatus(String roadId) {
        apiClient.getTfLFeed(RoadCheckerPresenter.this, roadId);
    }

    @Override
    public void receiveDataCallback(Status data) {
        view.displayRoadStatus(data);
    }
}
