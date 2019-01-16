package com.demos.henrique.tflroadchecker.networking;

public class DataRepository {
    public static DataContract getRepository(String baseEndPointUrl, String appId, String apiSecret) {
        return new TflApi(baseEndPointUrl, appId, apiSecret);
    }
}
