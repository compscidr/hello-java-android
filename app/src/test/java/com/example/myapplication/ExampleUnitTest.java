package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /*
     * Test something that the connectedTest doesn't so that we can see that both the off and on
     * device coverage is working.
     */
    @Test
    public void testSomethingForCoverage() {
        SecondFragment fragment = new SecondFragment();
        fragment.onDestroyView();
    }
}