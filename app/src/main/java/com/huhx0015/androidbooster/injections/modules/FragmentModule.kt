package com.huhx0015.androidbooster.injections.modules

import androidx.fragment.app.Fragment
import com.huhx0015.androidbooster.injections.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule (private val fragment: Fragment) {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ActivityScope
    fun providesFragment(): Fragment {
        return fragment
    }
}