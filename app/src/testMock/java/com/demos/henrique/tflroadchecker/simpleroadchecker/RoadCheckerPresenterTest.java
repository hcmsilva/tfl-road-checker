package com.demos.henrique.tflroadchecker.simpleroadchecker;

import com.demos.henrique.tflroadchecker.networking.ApiFakeImpl;
import com.demos.henrique.tflroadchecker.networking.DataContract;
import com.demos.henrique.tflroadchecker.simpleroadchecker.SimpleCheckerContract.SimpleCheckerViewContract;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RoadCheckerPresenterTest {

    private SimpleCheckerViewContract mockView = mock(SimpleCheckerViewContract.class);
    private DataContract mockApiClient = mock(DataContract.class);
    private RoadCheckerPresenter mPresenter;
    private String mockRoadId = "aaa";

    private DataContract fakeApi = new ApiFakeImpl(); //belongs to mock srcSet

    @Test
    public void verifyGetRoadStatusMakesApiCall() {

        mPresenter = new RoadCheckerPresenter(mockView, mockApiClient);
        mPresenter.getRoadStatus(mockRoadId);

        verify(mockApiClient, times(1)).getTfLFeed(mPresenter, mockRoadId);
    }

    // note: this test should be exclusively run in mock flavour
    @Test
    public void receiveDataCallback() {

        mPresenter = new RoadCheckerPresenter(mockView, fakeApi);
        mPresenter.getRoadStatus(mockRoadId);

        verify(mockView, times(1)).displayRoadStatus(any());
    }
}