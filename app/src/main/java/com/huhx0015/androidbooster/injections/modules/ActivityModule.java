package com.huhx0015.androidbooster.injections.modules;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.PropertyChangeRegistry;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    @NonNull
    private AppCompatActivity mActivity;
    @NonNull
    private Context mContext;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ActivityModule(@NonNull AppCompatActivity activity) {
        this.mActivity = activity;
        this.mContext = activity;
    }

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @NonNull
    @ActivityScope
    AppCompatActivity providesActivity() {
        return mActivity;
    }

    @Provides
    @NonNull
    @ActivityScope
    CompositeDisposable providesDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @NonNull
    @ActivityScope
    Context providesContext() {
        return mContext;
    }

    @Provides
    @NonNull
    @ActivityScope
    FragmentManager providesFragmentMananger(@NonNull AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @NonNull
    @ActivityScope
    Lifecycle providesLifecycle(@NonNull AppCompatActivity activity) {
        return activity.getLifecycle();
    }

    @Provides
    @NonNull
    @ActivityScope
    PropertyChangeRegistry providesPropertyChangeRegistery() {
        return new PropertyChangeRegistry();
    }
}