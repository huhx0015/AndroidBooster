package com.huhx0015.androidbooster.injections.modules;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    @NonNull
    private Fragment mFragment;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public FragmentModule(@NonNull Fragment fragment) {
        this.mFragment = fragment;
    }

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @NonNull
    @ActivityScope
    Fragment providesFragment() {
        return mFragment;
    }
}