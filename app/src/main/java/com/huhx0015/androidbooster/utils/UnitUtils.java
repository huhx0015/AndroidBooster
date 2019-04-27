package com.huhx0015.androidbooster.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;

/**
 * Source: http://stackoverflow.com/questions/4605527/converting-pixels-to-dp
 */

public class UnitUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    /**
     * convertDpToPixels(): This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param context Context to get resources and device specific display metrics
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixels(@NonNull Context context, float dp){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * convertPixelsToDp(): This method converts device specific pixels to density independent pixels.
     *
     * @param context Context to get resources and device specific display metrics
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(@NonNull Context context, float px){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}