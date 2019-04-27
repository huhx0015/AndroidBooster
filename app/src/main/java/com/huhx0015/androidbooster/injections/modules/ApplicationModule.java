package com.huhx0015.androidbooster.injections.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import com.huhx0015.androidbooster.constants.AndroidConstants;
import com.huhx0015.androidbooster.rx.RxBus;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private Application mApplication;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ApplicationModule(@NonNull Application application) {
        mApplication = application;
    }

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @NonNull
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @NonNull
    @Singleton
    AssetManager providesAssetMaanger(@NonNull Context context) {
        return context.getAssets();
    }

    @Provides
    @NonNull
    @Singleton
    Context providesContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    ConnectivityManager providesConnectivityManager(@NonNull Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    @NonNull
    @Singleton
    RxBus providesRxBus() {
        return new RxBus();
    }

    @Provides
    @NonNull
    @Singleton
    SharedPreferences providesSharedPreferences(@NonNull Context context) {
        return context.getSharedPreferences(AndroidConstants.ANDROID_PREFERENCES,
                Context.MODE_PRIVATE);
    }
}