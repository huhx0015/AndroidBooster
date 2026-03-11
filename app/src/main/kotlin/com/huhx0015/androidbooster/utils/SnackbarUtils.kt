package com.huhx0015.androidbooster.utils

import com.google.android.material.snackbar.Snackbar
import android.view.View

object SnackbarUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    fun displaySnackbar(parentView: View, message: String, length: Int, color: Int) {
        val snackbar = Snackbar.make(parentView, message, length)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(color)
        snackbar.show()
    }

    fun displaySnackbarWithAction(parentView: View, message: String, length: Int, color: Int,
                                  actionText: String, listener: View.OnClickListener) {
        val snackbar = Snackbar.make(parentView, message, length).setAction(actionText, listener)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(color)
        snackbar.show()
    }
}