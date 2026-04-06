package com.huhx0015.androidbooster.architecture.modules

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ActivityScoped
    fun providesLifecycle(@ActivityContext context: Context): Lifecycle {
        return (context as ComponentActivity).lifecycle
    }
}
