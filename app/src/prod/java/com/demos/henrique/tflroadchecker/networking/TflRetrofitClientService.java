package com.demos.henrique.tflroadchecker.networking;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TflRetrofitClientService {

    @GET("/Road/{roadId}")
    Call<ResponseBody> getRoadStatus(
            @Path("roadId") String rId,
            @Query("app_id") String appId,
            @Query("app_key") String appKey
    );
}
