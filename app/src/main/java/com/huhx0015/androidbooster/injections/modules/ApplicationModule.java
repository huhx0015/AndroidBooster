package com.huhx0015.androidbooster.injections.modules;

import android.app.Application;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Michael Yoon Huh on 6/23/2017.
 */

@Module
public class ApplicationModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private Application mApplication;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
