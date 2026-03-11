package com.huhx0015.androidbooster.injections.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ActivityScoped
    fun providesDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScoped
    fun providesFragmentMananger(@ActivityContext context: Context): FragmentManager {
        return (context as AppCompatActivity).supportFragmentManager
    }

    @Provides
    @ActivityScoped
    fun providesLifecycle(@ActivityContext context: Context): Lifecycle {
        return (context as AppCompatActivity).lifecycle
    }
}