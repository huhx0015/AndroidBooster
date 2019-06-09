package com.huhx0015.androidbooster.utils

import android.content.Context
import android.util.DisplayMetrics

/**
 * Source: http://stackoverflow.com/questions/4605527/converting-pixels-to-dp
 */

object UnitUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    /**
     * convertDpToPixels(): This method converts dp unit to equivalent pixels, depending on device
     * density.
     *
     * @param context Context to get resources and device specific display metrics
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into
     * pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    fun convertDpToPixels(context: Context, dp: Float): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    /**
     * convertPixelsToDp(): This method converts device specific pixels to density independent
     * pixels.
     *
     * @param context Context to get resources and device specific display metrics
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return A float value to represent dp equivalent to px value
     */
    fun convertPixelsToDp(context: Context, px: Float): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}