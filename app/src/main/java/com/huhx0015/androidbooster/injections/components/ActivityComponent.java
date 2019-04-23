package com.huhx0015.androidbooster.injections.components;

import androidx.annotation.NonNull;
import com.huhx0015.androidbooster.architecture.base.BaseActivity;
import com.huhx0015.androidbooster.architecture.base.BaseViewModel;
import com.huhx0015.androidbooster.injections.modules.ActivityModule;
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule;
import com.huhx0015.androidbooster.injections.modules.ViewModelModule;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(modules = {
        ActivityModule.class,
        RecyclerViewModule.class,
        ViewModelModule.class
},
        dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(@NonNull BaseActivity activity);
    void inject(@NonNull BaseViewModel viewModel);
}