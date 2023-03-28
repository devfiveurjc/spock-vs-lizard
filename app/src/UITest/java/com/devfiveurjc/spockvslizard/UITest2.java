package com.devfiveurjc.spockvslizard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@BeforeClass
public static void setUpClass() {
        }

@AfterClass
public static void tearDownClass() {
        }

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() { assertEquals(5, 2 + 3); }
}


public class UITest2 {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.devfiveurjc.spockvslizard", appContext.getPackageName());
    }
}
