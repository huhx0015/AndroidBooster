package com.huhx0015.androidbooster.application;

import android.app.Application;
import com.huhx0015.androidbooster.constants.AndroidConstants;
import com.huhx0015.androidbooster.injections.components.NetworkComponent;
import com.huhx0015.androidbooster.injections.modules.ApplicationModule;
import com.huhx0015.androidbooster.injections.modules.NetworkModule;
import com.huhx0015.androidbooster.injections.components.DaggerNetworkComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

public class AndroidApplication extends Application {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private NetworkComponent mNetworkComponent;
    private RefWatcher mRefWatcher;

    /** APPLICATION LIFECYCLE METHODS __________________________________________________________ **/

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        initLeakCanary();
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
    protected RefWatcher initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    /** GET METHODS ____________________________________________________________________________ **/

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }

}