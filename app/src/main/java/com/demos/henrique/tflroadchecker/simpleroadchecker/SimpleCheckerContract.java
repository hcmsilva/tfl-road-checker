package com.demos.henrique.tflroadchecker.simpleroadchecker;

import com.demos.henrique.tflroadchecker.model.ErrorStatus;
import com.demos.henrique.tflroadchecker.model.RoadStatus;
import com.demos.henrique.tflroadchecker.model.Status;

public interface SimpleCheckerContract {

    interface SimpleCheckerViewContract {
        void displayRoadStatus(RoadStatus status);
        void displayError(ErrorStatus errorStatus);
    }

    interface SimpleCheckerPresenterContract {
        Status getRoadStatus(String roadId);
    }
}
