package com.huhx0015.androidbooster.injections.modules;

import android.content.Context;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import com.google.android.gms.location.LocationRequest;
import com.huhx0015.androidbooster.injections.scopes.ServiceScope;
import dagger.Module;
import dagger.Provides;

@Module
public class LocationModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // CONSTANT VARIABLES:
    private static final int UPDATE_INTERVAL = 10000;
    private static final int FASTEST_INTERVAL = 5000;

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @ServiceScope
    LocationManager providesLocationManager(@NonNull Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @NonNull
    @ServiceScope
    LocationRequest providesLocationRequest() {
        LocationRequest request = new LocationRequest();
        request.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        request.setInterval(UPDATE_INTERVAL);
        request.setFastestInterval(FASTEST_INTERVAL);
        request.setExpirationDuration(UPDATE_INTERVAL);
        return request;
    }
}