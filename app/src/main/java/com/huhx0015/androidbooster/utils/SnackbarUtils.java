package com.huhx0015.androidbooster.utils;

import com.google.android.material.snackbar.Snackbar;
import android.view.View;

public class SnackbarUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    public static void displaySnackbar(View parentView, String message, int length, int color) {
        Snackbar snackbar = Snackbar.make(parentView, message, length);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);
        snackbar.show();
    }

    public static void displaySnackbarWithAction(View parentView, String message, int length, int color,
                                                 String actionText, View.OnClickListener listener) {
        Snackbar snackbar = Snackbar.make(parentView, message, length)
                .setAction(actionText, listener);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);
        snackbar.show();
    }
}