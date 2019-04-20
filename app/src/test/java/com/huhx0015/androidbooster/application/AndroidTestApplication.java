package com.huhx0015.androidbooster.application;

import com.huhx0015.androidbooster.injections.components.DaggerNetworkComponent;
import com.huhx0015.androidbooster.injections.modules.NetworkModule;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

public class AndroidTestApplication extends AndroidApplication {

    /** APPLICATION LIFECYCLE METHODS __________________________________________________________ **/

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    private void initDagger() {

        // DAGGER NETWORK COMPONENT:
//        setNetworkComponent(DaggerNetworkComponent.builder()
//                .networkModule(new NetworkModule(RESTMockServer.getUrl()))
//                .build());
    }
}
