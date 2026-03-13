package com.huhx0015.androidbooster.architecture.modules

import com.huhx0015.androidbooster.architecture.event.RxBus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RxBusModule {

    @Provides
    @Singleton
    fun providesRxBus(): RxBus = RxBus()
}
