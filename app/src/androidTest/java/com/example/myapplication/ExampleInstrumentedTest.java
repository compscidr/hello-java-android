package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import android.content.Context;
import org.junit.jupiter.api.Test;

import androidx.test.platform.app.InstrumentationRegistry;

import de.mannodermaus.junit5.ActivityScenarioExtension;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myapplication", appContext.getPackageName());

        ActivityScenarioExtension.launch(MainActivity.class);
    }
}