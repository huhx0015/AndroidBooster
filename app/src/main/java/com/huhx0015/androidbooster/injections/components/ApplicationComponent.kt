package com.huhx0015.androidbooster.injections.components

import com.huhx0015.androidbooster.application.AndroidApplication
import com.huhx0015.androidbooster.injections.modules.ApplicationModule
import com.huhx0015.androidbooster.injections.modules.NetworkModule
import dagger.Component

@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
}