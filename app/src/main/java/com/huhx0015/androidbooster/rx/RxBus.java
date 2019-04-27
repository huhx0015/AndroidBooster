package com.huhx0015.androidbooster.rx;

import androidx.annotation.NonNull;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import javax.inject.Singleton;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 *  Reference: https://blog.mindorks.com/implementing-eventbus-with-rxjava-rxbus-e6c940a94bd8
 */

@Singleton
public class RxBus {

    /** RXBUS METHODS __________________________________________________________________________ **/

    private final Relay<Object> mBus = PublishRelay.create().toSerialized();

    public Flowable<Object> asFlowable() {
        return mBus.toFlowable(BackpressureStrategy.LATEST);
    }

    /** ACTION METHODS _________________________________________________________________________ **/

    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    public void send(@NonNull Object object) {
        mBus.accept(object);
    }
}