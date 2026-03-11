package com.huhx0015.androidbooster.utils

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import coil3.load
import com.huhx0015.androidbooster.R

object BindingUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    @BindingAdapter("app:imageUrl")
    fun loadImage(view: ImageView, imageUrl: String) {
        view.load(imageUrl) {
            error(R.mipmap.ic_launcher)
        }
    }
}