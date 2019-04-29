package com.huhx0015.androidbooster.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import android.view.WindowManager;
import com.huhx0015.androidbooster.R;
import timber.log.Timber;

public class DialogUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    public static void displayAlertDialog(@NonNull Context context, @NonNull String title,
                                          @NonNull String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    public static ProgressDialog createProgressDialog(@NonNull Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_progress);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            Timber.e("ERROR: %s", e.getLocalizedMessage());
        }
        return dialog;
    }
}