package com.huhx0015.androidbooster.injections.modules;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.huhx0015.androidbooster.architecture.base.BaseViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    BaseViewModel providesBaseViewModel(@NonNull AppCompatActivity activity) {
        return ViewModelProviders.of(activity).get(BaseViewModel.class);
    }
}