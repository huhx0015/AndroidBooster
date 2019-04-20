package com.huhx0015.androidbooster;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * Reference: http://d.android.com/tools/testing
 */
@RunWith(AndroidJUnit4.class)
public class AndroidInstrumentedTest {

    /** TEST METHODS ___________________________________________________________________________ **/

    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals(appContext.getString(R.string.app_name), appContext.getPackageName());
    }
}
