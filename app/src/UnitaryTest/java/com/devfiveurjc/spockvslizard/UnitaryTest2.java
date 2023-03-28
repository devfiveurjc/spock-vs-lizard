package com.devfiveurjc.spockvslizard;

import org.junit.Test;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class UnitaryTest2 {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.devfiveurjc.spockvslizard", appContext.getPackageName());
    }
}

