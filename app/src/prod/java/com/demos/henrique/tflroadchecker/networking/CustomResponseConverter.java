package com.demos.henrique.tflroadchecker.networking;

import com.demos.henrique.tflroadchecker.dto.ErrorStatusDto;
import com.demos.henrique.tflroadchecker.dto.RoadStatusDto;
import com.demos.henrique.tflroadchecker.model.ErrorStatus;
import com.demos.henrique.tflroadchecker.model.RoadStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ResponseBody;

import java.io.IOException;

public class CustomResponseConverter {
    public static RoadStatus getRoadStatusDto(ResponseBody roadStatusDto) {
        Gson gson = new GsonBuilder().create();
        RoadStatusDto[] dtoArray = new RoadStatusDto[0];
        try {
            dtoArray = gson.fromJson(roadStatusDto.string(), RoadStatusDto[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new RoadStatus(dtoArray[0]);
    }

    public static ErrorStatus getErrorStatusFromDto(ResponseBody errorStatusDto) {
        Gson gson = new GsonBuilder().create();
        ErrorStatusDto dto = new ErrorStatusDto();
        try {
            dto = gson.fromJson(errorStatusDto.string(), ErrorStatusDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ErrorStatus(dto);
    }
}