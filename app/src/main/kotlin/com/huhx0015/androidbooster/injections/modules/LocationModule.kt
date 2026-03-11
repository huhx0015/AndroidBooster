package com.huhx0015.androidbooster.injections.modules

import android.content.Context
import android.location.LocationManager
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.Priority
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
object LocationModule {

    /** CONSTANTS ______________________________________________________________________________  */

    private const val UPDATE_INTERVAL = 10000L
    private const val FASTEST_INTERVAL = 5000L

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ServiceScoped
    fun providesLocationManager(@ApplicationContext context: Context): LocationManager {
        return context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    @ServiceScoped
    fun providesLocationRequest(): LocationRequest {
        return LocationRequest.Builder(Priority.PRIORITY_BALANCED_POWER_ACCURACY, UPDATE_INTERVAL)
            .setMinUpdateIntervalMillis(FASTEST_INTERVAL)
            .setMaxUpdateDelayMillis(UPDATE_INTERVAL)
            .build()
    }
}