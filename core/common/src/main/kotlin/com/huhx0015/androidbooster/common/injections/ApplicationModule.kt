package com.huhx0015.androidbooster.common.injections

import android.content.Context
import android.content.SharedPreferences
import android.content.res.AssetManager
import android.net.ConnectivityManager
import com.huhx0015.androidbooster.constants.AndroidConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @Singleton
    fun providesAssetMaanger(@ApplicationContext context: Context): AssetManager {
        return context.assets
    }

    @Provides
    @Singleton
    fun providesConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(AndroidConstants.ANDROID_PREFERENCES,
                Context.MODE_PRIVATE)
    }
}
