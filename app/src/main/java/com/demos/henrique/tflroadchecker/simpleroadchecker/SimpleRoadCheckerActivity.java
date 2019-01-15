package com.demos.henrique.tflroadchecker.simpleroadchecker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.demos.henrique.tflroadchecker.R;
import com.demos.henrique.tflroadchecker.model.ErrorStatus;
import com.demos.henrique.tflroadchecker.model.RoadStatus;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerViewContract;

public class SimpleRoadCheckerActivity
        extends AppCompatActivity
        implements SimpleCheckerViewContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_road_checker);


    }

    @Override
    public void displayRoadStatus(RoadStatus status) {

    }

    @Override
    public void displayError(ErrorStatus errorStatus) {

    }
}
