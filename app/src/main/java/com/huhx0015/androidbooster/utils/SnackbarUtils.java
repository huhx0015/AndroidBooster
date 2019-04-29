package com.huhx0015.androidbooster.utils;

import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import androidx.annotation.NonNull;

public class SnackbarUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    public static void displaySnackbar(@NonNull View parentView, @NonNull String message,
                                       int length, int color) {
        Snackbar snackbar = Snackbar.make(parentView, message, length);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);
        snackbar.show();
    }

    public static void displaySnackbarWithAction(@NonNull View parentView, @NonNull String message,
                                                 int length, int color, @NonNull String actionText,
                                                 @NonNull View.OnClickListener listener) {
        Snackbar snackbar = Snackbar.make(parentView, message, length)
                .setAction(actionText, listener);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);
        snackbar.show();
    }
}