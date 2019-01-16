package com.demos.henrique.tflroadchecker.networking;

import com.demos.henrique.tflroadchecker.model.Status;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TflApi implements DataContract {

    private static String API_BASE_URL;
    private final String appId;
    private final String apiKey;
    private Retrofit retrofit;

    public TflApi(String endPointBaseUrl, String appId, String apiKey) {
        API_BASE_URL = endPointBaseUrl;
        this.appId = appId;
        this.apiKey = apiKey;
        retrofit = getRetrofitInstance();
    }

    private Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @Override
    public void getTfLFeed(final DataReceiver<Status> statusDataReceiver, String roadId) {
        TflRetrofitClientService apiService = getRetrofitInstance().create(TflRetrofitClientService.class);

        Call<ResponseBody> mCall = apiService.getRoadStatus(roadId, appId, apiKey);
        //todo modify for espresso automated testing (idle res increment)
        mCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Status result;

                if (response.code() == 200) {
                    result = CustomResponseConverter.getRoadStatusDto(response.body());
                } else {
                    result = CustomResponseConverter.getErrorStatusFromDto(response.errorBody());
                }

                statusDataReceiver.receiveDataCallback(result);
                //todo modify for espresso automated testing (idle res decrement)
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                //todo modify for espresso automated testing (idle res decrement)
            }
        });
    }
}
