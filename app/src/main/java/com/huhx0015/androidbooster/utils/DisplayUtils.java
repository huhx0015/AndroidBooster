package com.huhx0015.androidbooster.utils;

import android.content.Context;
import androidx.annotation.NonNull;

public class DisplayUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    /**
     * getOrientation(): Retrieves the device's current orientation.
     *
     * Configuration.ORIENTATION_PORTRAIT
     * Configuration.ORIENTATION_LANDSCAPE
     * @param context
     * @return
     */
    public static int getOrientation(@NonNull Context context) {
        return context.getResources().getConfiguration().orientation;
    }
}
