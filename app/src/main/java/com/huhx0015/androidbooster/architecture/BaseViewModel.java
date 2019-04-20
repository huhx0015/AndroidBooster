package com.huhx0015.androidbooster.architecture;

import android.app.Application;
import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

public class BaseViewModel extends AndroidViewModel implements LifecycleOwner, Observable {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private Lifecycle mLifecycle;
    protected PropertyChangeRegistry mRegistry = new PropertyChangeRegistry();

    /** CONSTRUCTOR ____________________________________________________________________________ **/

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    /** LIFECYCLE METHODS ______________________________________________________________________ **/

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(@NonNull Context context) {
        mLifecycle = ((AppCompatActivity) context).getLifecycle();
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {}

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {}

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        removeOnPropertyChangedCallback(null);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycle;
    }

    /** DATABINDING METHODS ____________________________________________________________________ **/

    @Override
    public void addOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
        mRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(@Nullable OnPropertyChangedCallback callback) {
        mRegistry.remove(callback);
    }
}