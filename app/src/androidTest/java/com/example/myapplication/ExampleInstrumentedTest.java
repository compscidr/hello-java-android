package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import android.content.Context;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;

import de.mannodermaus.junit5.ActivityScenarioExtension;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
    @RegisterExtension
    ActivityScenarioExtension<MainActivity> scenarioExtension = ActivityScenarioExtension.launch(MainActivity.class);

    @Test
    public void useAppContext(ActivityScenario<MainActivity> scenario) {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myapplication", appContext.getPackageName());

        scenario.onActivity(activity -> {

        });

    }
}