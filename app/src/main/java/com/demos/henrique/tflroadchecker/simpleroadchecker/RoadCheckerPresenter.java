package com.demos.henrique.tflroadchecker.simpleroadchecker;

import com.demos.henrique.tflroadchecker.model.Status;
import com.demos.henrique.tflroadchecker.networking.DataReceiver;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerPresenterContract;

public class RoadCheckerPresenter implements SimpleCheckerPresenterContract, DataReceiver<Status> {
    @Override
    public Status getRoadStatus(String roadId) {
        return null;
    }

    @Override
    public void receiveDataCallback(Status data) {

    }
}
