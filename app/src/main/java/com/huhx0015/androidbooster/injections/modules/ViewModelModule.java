package com.huhx0015.androidbooster.injections.modules;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.huhx0015.androidbooster.viewmodel.ApiRecyclerViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    ApiRecyclerViewModel providesApiRecyclerViewModel(@NonNull AppCompatActivity activity) {
        return ViewModelProviders.of(activity).get(ApiRecyclerViewModel.class);
    }
}