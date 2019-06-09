package com.huhx0015.androidbooster.injections.components

import com.huhx0015.androidbooster.architecture.base.BaseActivity
import com.huhx0015.androidbooster.architecture.base.BaseViewModel
import com.huhx0015.androidbooster.injections.modules.ActivityModule
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule
import com.huhx0015.androidbooster.injections.modules.ViewModelModule
import com.huhx0015.androidbooster.injections.scopes.ActivityScope
import javax.inject.Singleton
import dagger.Component

@ActivityScope
@Singleton
@Component(
        modules = [ActivityModule::class, RecyclerViewModule::class, ViewModelModule::class],
        dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(activity: BaseActivity)
    fun inject(viewModel: BaseViewModel)
}