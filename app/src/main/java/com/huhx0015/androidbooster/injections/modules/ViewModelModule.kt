package com.huhx0015.androidbooster.injections.modules

import androidx.databinding.PropertyChangeRegistry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun providesDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ViewModelScoped
    fun providesPropertyChangeRegistry(): PropertyChangeRegistry {
        return PropertyChangeRegistry()
    }
}