package com.huhx0015.androidbooster.injections.components

import com.huhx0015.androidbooster.architecture.base.BaseFragment
import com.huhx0015.androidbooster.injections.modules.FragmentModule
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule
import com.huhx0015.androidbooster.injections.modules.ViewModelModule
import com.huhx0015.androidbooster.injections.scopes.ActivityScope
import javax.inject.Singleton
import dagger.Component

@ActivityScope
@Singleton
@Component(
        modules = [FragmentModule::class, RecyclerViewModule::class, ViewModelModule::class],
        dependencies = [ApplicationComponent::class])
interface FragmentComponent {
    fun inject(fragment: BaseFragment)
}