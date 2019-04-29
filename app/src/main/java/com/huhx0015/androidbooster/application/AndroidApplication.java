package com.huhx0015.androidbooster.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.huhx0015.androidbooster.BuildConfig;
import com.huhx0015.androidbooster.constants.AndroidConstants;
import com.huhx0015.androidbooster.injections.components.ApplicationComponent;
import com.huhx0015.androidbooster.injections.components.DaggerApplicationComponent;
import com.huhx0015.androidbooster.injections.modules.ApplicationModule;
import com.huhx0015.androidbooster.injections.modules.NetworkModule;
import com.huhx0015.androidbooster.logging.ReleaseTree;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import timber.log.Timber;

public class AndroidApplication extends Application {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private ApplicationComponent mComponent;

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
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(AndroidConstants.API_URL))
                .build();
        mComponent.inject(this);
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

    @NonNull
    public static AndroidApplication get(@NonNull Application application) {
        return (AndroidApplication) application;
    }

    @NonNull
    public static AndroidApplication get(@NonNull Activity activity) {
        return (AndroidApplication) activity.getApplicationContext();
    }

    @NonNull
    public static AndroidApplication get(@NonNull Context context) {
        return (AndroidApplication) context.getApplicationContext();
    }

    @NonNull
    public ApplicationComponent getComponent() {
        return mComponent;
    }
}