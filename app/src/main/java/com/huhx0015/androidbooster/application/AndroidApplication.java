package com.huhx0015.androidbooster.application;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.huhx0015.androidbooster.BuildConfig;
import com.huhx0015.androidbooster.constants.AndroidConstants;
import com.huhx0015.androidbooster.injections.components.ApplicationComponent;
import com.huhx0015.androidbooster.injections.modules.ApplicationModule;
import com.huhx0015.androidbooster.injections.modules.NetworkModule;
import com.huhx0015.androidbooster.injections.components.DaggerNetworkComponent;
import com.huhx0015.androidbooster.logging.ReleaseTree;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import timber.log.Timber;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

public class AndroidApplication extends Application {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private ApplicationComponent mApplicationComponent;
    private NetworkComponent mNetworkComponent;
    private RefWatcher mRefWatcher;

    /** APPLICATION LIFECYCLE METHODS __________________________________________________________ **/

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        initLeakCanary();
        initTimber();
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    // DAGGER:
    private void initDagger() {

        // DAGGER NETWORK COMPONENT:
        mNetworkComponent = DaggerNetworkComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(AndroidConstants.API_URL))
                .build();
    }

    // LEAK CANARY:
    private RefWatcher initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    // TIMBER:
    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }

    /** GET METHODS ____________________________________________________________________________ **/

    public static AndroidApplication get(@NonNull Context context) {
        return (AndroidApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }
}