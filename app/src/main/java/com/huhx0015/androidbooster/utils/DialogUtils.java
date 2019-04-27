package com.huhx0015.androidbooster.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AlertDialog;
import android.view.WindowManager;
import com.huhx0015.androidbooster.R;
import timber.log.Timber;

public class DialogUtils {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private static final String LOG_TAG = DialogUtils.class.getSimpleName();

    /** UTILITY METHODS ________________________________________________________________________ **/

    public static void displayAlertDialog(String title, String message, Context context) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            Timber.e("ERROR: %s", e.getLocalizedMessage());
        }
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_progress);
        dialog.show();
        return dialog;
    }
}
