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

        initLeakCanary();
        initDagger();
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    private void initLeakCanary() {

        // LEAK CANARY:
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initDagger() {

        // DAGGER NETWORK COMPONENT:
        mNetworkComponent = DaggerNetworkComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(AndroidConstants.API_URL))
                .build();
    }

    /** GET METHODS ____________________________________________________________________________ **/

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }

    /** SET METHODS ____________________________________________________________________________ **/

    public void setNetworkComponent(NetworkComponent mNetworkComponent) {
        this.mNetworkComponent = mNetworkComponent;
    }
}
