package com.huhx0015.androidbooster.injections.modules;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @NonNull
    private Context mContext;
    @NonNull
    private AppCompatActivity mActivity;

    public ActivityModule(@NonNull AppCompatActivity activity) {
        this.mActivity = activity;
        this.mContext = activity;
    }

    @Provides
    @ActivityScope
    Context providesContext() {
        return mContext;
    }

    @Provides
    @ActivityScope
    AppCompatActivity providesActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager providesFragmentMananger(@NonNull AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }
}