package com.huhx0015.androidbooster.injections.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.huhx0015.androidbooster.viewmodel.ApiRecyclerViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    fun providesApiRecyclerViewModel(activity: AppCompatActivity): ApiRecyclerViewModel {
        return ViewModelProviders.of(activity).get(ApiRecyclerViewModel::class.java)
    }
}