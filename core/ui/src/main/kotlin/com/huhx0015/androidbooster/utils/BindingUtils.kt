package com.huhx0015.androidbooster.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil3.load
import com.huhx0015.androidbooster.ui.R

object BindingUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    @BindingAdapter("app:imageUrl")
    fun loadImage(view: ImageView, imageUrl: String) {
        view.load(imageUrl) {
            error(R.drawable.ic_image_placeholder)
        }
    }
}
