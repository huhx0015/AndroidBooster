package com.huhx0015.androidbooster.utils;

import androidx.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.huhx0015.androidbooster.R;

/**
 * Source: https://android.jlelse.eu/loading-images-with-data-binding-and-picasso-555dad683fdc#.wqu65ag8e
 */

public class BindingUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view)
                .load(imageUrl)
                .error(R.mipmap.ic_launcher)
                .into(view);
    }
}