package com.huhx0015.androidbooster.injections.components

import com.huhx0015.androidbooster.injections.modules.LocationModule
import com.huhx0015.androidbooster.injections.scopes.ServiceScope
import javax.inject.Singleton
import dagger.Component

@ServiceScope
@Singleton
@Component(
        modules = [LocationModule::class],
        dependencies = [ApplicationComponent::class])
interface ServiceComponent