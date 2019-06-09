package com.huhx0015.androidbooster.utils

import android.content.Context

object DisplayUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    /**
     * getOrientation(): Retrieves the device's current orientation.
     *
     * Configuration.ORIENTATION_PORTRAIT
     * Configuration.ORIENTATION_LANDSCAPE
     * @param context
     * @return
     */
    fun getOrientation(context: Context): Int {
        return context.resources.configuration.orientation
    }
}
