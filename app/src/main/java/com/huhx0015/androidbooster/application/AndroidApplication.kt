package com.huhx0015.androidbooster.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.huhx0015.androidbooster.BuildConfig
import com.huhx0015.androidbooster.logging.ReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
open class AndroidApplication : Application() {

    /** COMPANION ______________________________________________________________________________ **/

    companion object {

        fun get(application: Application): AndroidApplication {
            return application as AndroidApplication
        }

        fun get(activity: Activity): AndroidApplication {
            return activity.applicationContext as AndroidApplication
        }

        fun get(context: Context): AndroidApplication {
            return context.applicationContext as AndroidApplication
        }
    }

    /** APPLICATION LIFECYCLE METHODS __________________________________________________________  */

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    /** INIT METHODS ___________________________________________________________________________  */

    // TIMBER:
    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree()) else Timber.plant(ReleaseTree())
    }
}