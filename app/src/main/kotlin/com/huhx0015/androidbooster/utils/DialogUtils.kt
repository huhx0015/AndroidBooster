package com.huhx0015.androidbooster.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import android.view.WindowManager
import com.huhx0015.androidbooster.R
import timber.log.Timber

object DialogUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    fun displayAlertDialog(context: Context, title: String, message: String) {
        AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.ok)) { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
    }

    fun createProgressDialog(context: Context): ProgressDialog {
        val dialog = ProgressDialog(context)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_progress)

        try {
            dialog.show()
        } catch (e: WindowManager.BadTokenException) {
            Timber.e("ERROR: %s", e.localizedMessage)
        }

        return dialog
    }
}