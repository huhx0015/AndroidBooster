package com.huhx0015.androidbooster.injections.components;

import androidx.annotation.NonNull;
import com.huhx0015.androidbooster.architecture.base.BaseFragment;
import com.huhx0015.androidbooster.injections.modules.FragmentModule;
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule;
import com.huhx0015.androidbooster.injections.modules.ViewModelModule;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {
        FragmentModule.class,
        RecyclerViewModule.class,
        ViewModelModule.class
},
        dependencies = ApplicationComponent.class)
public interface FragmentComponent {
    void inject(@NonNull BaseFragment fragment);
}