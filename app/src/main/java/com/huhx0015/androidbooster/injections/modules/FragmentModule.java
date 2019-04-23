package com.huhx0015.androidbooster.injections.modules;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @NonNull
    private Fragment mFragment;

    public FragmentModule(@NonNull Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @ActivityScope
    Fragment providesFragment() {
        return mFragment;
    }
}