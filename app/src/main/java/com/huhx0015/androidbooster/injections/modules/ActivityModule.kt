package com.huhx0015.androidbooster.injections.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.PropertyChangeRegistry
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.huhx0015.androidbooster.injections.scopes.ActivityScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule (private val activity: AppCompatActivity) {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ActivityScope
    fun providesActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScope
    fun providesContext(): Context {
        return activity
    }

    @Provides
    @ActivityScope
    fun providesFragmentMananger(activity: AppCompatActivity): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    @ActivityScope
    fun providesLifecycle(activity: AppCompatActivity): Lifecycle {
        return activity.lifecycle
    }

    @Provides
    @ActivityScope
    fun providesPropertyChangeRegistery(): PropertyChangeRegistry {
        return PropertyChangeRegistry()
    }
}