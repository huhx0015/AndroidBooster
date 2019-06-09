package com.huhx0015.androidbooster.injections.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.AssetManager
import android.net.ConnectivityManager
import com.huhx0015.androidbooster.constants.AndroidConstants
import com.huhx0015.androidbooster.rx.RxBus
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun providesAssetMaanger(context: Context): AssetManager {
        return context.assets
    }

    @Provides
    @Singleton
    fun providesContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    fun providesRxBus(): RxBus {
        return RxBus()
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(AndroidConstants.ANDROID_PREFERENCES,
                Context.MODE_PRIVATE)
    }
}