package com.demos.henrique.tflroadchecker.networking;

public interface DataReceiver<T> {
    void receiveDataCallback(T data);
}
