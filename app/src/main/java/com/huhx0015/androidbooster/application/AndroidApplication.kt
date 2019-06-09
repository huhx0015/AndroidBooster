package com.huhx0015.androidbooster.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.huhx0015.androidbooster.BuildConfig
import com.huhx0015.androidbooster.constants.AndroidConstants
import com.huhx0015.androidbooster.injections.components.ApplicationComponent
import com.huhx0015.androidbooster.injections.components.DaggerApplicationComponent
import com.huhx0015.androidbooster.injections.modules.ApplicationModule
import com.huhx0015.androidbooster.injections.modules.NetworkModule
import com.huhx0015.androidbooster.logging.ReleaseTree
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber

open class AndroidApplication : Application() {

    /** CLASS VARIABLES ________________________________________________________________________  */

    var component: ApplicationComponent? = null

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

        initDagger()
        initLeakCanary()
        initTimber()
    }

    /** INIT METHODS ___________________________________________________________________________  */

    // DAGGER:
    private fun initDagger() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(AndroidConstants.API_URL))
                .build()
        component?.inject(this)
    }

    // LEAK CANARY:
    private fun initLeakCanary(): RefWatcher {
        return if (LeakCanary.isInAnalyzerProcess(this)) {
            RefWatcher.DISABLED
        } else LeakCanary.install(this)
    }

    // TIMBER:
    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree()) else Timber.plant(ReleaseTree())
    }
}