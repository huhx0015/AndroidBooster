package com.huhx0015.androidbooster.injections.components;

import androidx.annotation.NonNull;
import com.huhx0015.androidbooster.application.AndroidApplication;
import com.huhx0015.androidbooster.injections.modules.ApplicationModule;
import com.huhx0015.androidbooster.injections.modules.NetworkModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class
})
public interface ApplicationComponent {
    void inject(@NonNull AndroidApplication application);
}