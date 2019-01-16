package com.demos.henrique.tflroadchecker.simpleroadchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.demos.henrique.tflroadchecker.R;
import com.demos.henrique.tflroadchecker.model.Status;
import com.demos.henrique.tflroadchecker.networking.DataRepository;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerPresenterContract;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerViewContract;

public class SimpleRoadCheckerActivity extends AppCompatActivity
        implements SimpleCheckerViewContract {

    private EditText input;
    private TextView roadDisplayName;
    private TextView roadStatus;
    private TextView roadSeverity;
    private SimpleCheckerPresenterContract mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_road_checker);
        initFields();
    }

    private void initFields() {
        input = findViewById(R.id.road_id_edit_text);
        roadDisplayName = findViewById(R.id.road_display_name_content_tv);
        roadStatus = findViewById((R.id.road_status_content_tv));
        roadSeverity = findViewById(R.id.road_status_severity_description_content_tv);
        Button refreshButton = findViewById(R.id.refresh_button);

        mPresenter = new RoadCheckerPresenter(
                this,
                DataRepository.getRepository(getString(R.string.tfl_base_endpoint_url),
                        getString(R.string.tfl_application_id),
                        getString(R.string.api_secret)
                )
        );

        refreshButton.setOnClickListener(v -> mPresenter.getRoadStatus(input.getText().toString()));
    }

    @Override
    public void displayRoadStatus(Status status) {
        roadDisplayName.setText(status.getDisplayName());
        roadStatus.setText(status.getStatus());
        roadSeverity.setText(status.getDescription());
    }
}
