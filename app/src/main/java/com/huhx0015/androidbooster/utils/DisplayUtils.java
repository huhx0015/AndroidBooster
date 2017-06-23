package com.huhx0015.androidbooster.utils;

import android.content.Context;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

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
    public static int getOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }
}
