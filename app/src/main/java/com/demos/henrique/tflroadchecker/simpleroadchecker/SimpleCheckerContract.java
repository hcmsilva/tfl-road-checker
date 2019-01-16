package com.demos.henrique.tflroadchecker.simpleroadchecker;

import com.demos.henrique.tflroadchecker.model.Status;

public interface SimpleCheckerContract {

    interface SimpleCheckerViewContract {
        void displayRoadStatus(Status status);
    }

    interface SimpleCheckerPresenterContract {
        void getRoadStatus(String roadId);
    }
}
