package com.demos.henrique.tflroadchecker.networking;

import com.demos.henrique.tflroadchecker.model.Status;

public interface DataContract {
    void getTfLFeed(DataReceiver<Status> statusDataReceiver, String roadId);
}
