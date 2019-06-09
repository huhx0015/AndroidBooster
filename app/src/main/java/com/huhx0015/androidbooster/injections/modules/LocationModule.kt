package com.huhx0015.androidbooster.injections.modules

import android.content.Context
import android.location.LocationManager
import com.google.android.gms.location.LocationRequest
import com.huhx0015.androidbooster.injections.scopes.ServiceScope
import dagger.Module
import dagger.Provides

@Module
class LocationModule {

    /** CONSTANTS ______________________________________________________________________________  */

    companion object {
        private const val UPDATE_INTERVAL = 10000
        private const val FASTEST_INTERVAL = 5000
    }

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ServiceScope
    fun providesLocationManager(context: Context): LocationManager {
        return context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    @ServiceScope
    fun providesLocationRequest(): LocationRequest {
        val request = LocationRequest()
        request.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        request.interval = UPDATE_INTERVAL.toLong()
        request.fastestInterval = FASTEST_INTERVAL.toLong()
        request.setExpirationDuration(UPDATE_INTERVAL.toLong())
        return request
    }
}