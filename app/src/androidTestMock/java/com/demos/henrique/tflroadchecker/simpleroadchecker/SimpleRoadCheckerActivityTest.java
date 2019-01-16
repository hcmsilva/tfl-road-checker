package com.demos.henrique.tflroadchecker.simpleroadchecker;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.demos.henrique.tflroadchecker.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SimpleRoadCheckerActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(SimpleRoadCheckerActivity.class);


    @Test
    public void insertTextPressRefresh() {
        Espresso.onView(ViewMatchers.withId(R.id.road_id_edit_text))
                .perform(ViewActions.typeText("mock-id")).perform(ViewActions.closeSoftKeyboard());

        // uncomment for demo purposes (otherwise is just too fast =) )
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Espresso.onView(ViewMatchers.withId(R.id.refresh_button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.road_display_name_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("Mock Road 9999")));
        Espresso.onView(ViewMatchers.withId(R.id.road_status_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("Super mocked")));
        Espresso.onView(ViewMatchers.withId(R.id.road_status_severity_description_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("I describe myself as a mock")));
    }

    @Test
    public void insertTextPressRefreshFirstAndSecondTimeGetsMockError() {
        Espresso.onView(ViewMatchers.withId(R.id.road_id_edit_text))
                .perform(ViewActions.typeText("mock-id")).perform(ViewActions.closeSoftKeyboard());

        // uncomment for demo purposes (otherwise is just too fast =) )
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Espresso.onView(ViewMatchers.withId(R.id.refresh_button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.road_display_name_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("Mock Road 9999")));
        Espresso.onView(ViewMatchers.withId(R.id.road_status_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("Super mocked")));
        Espresso.onView(ViewMatchers.withId(R.id.road_status_severity_description_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("I describe myself as a mock")));

        Espresso.onView(ViewMatchers.withId(R.id.refresh_button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.road_status_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("Error Code: mock road cannot be found")));
        Espresso.onView(ViewMatchers.withId(R.id.road_status_severity_description_content_tv))
                .check(ViewAssertions.matches(ViewMatchers.withText("Made up mock error message")));
    }
}
