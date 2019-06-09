package com.huhx0015.androidbooster.rx

import com.jakewharton.rxrelay2.PublishRelay
import javax.inject.Singleton
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

/**
 * Reference: https://blog.mindorks.com/implementing-eventbus-with-rxjava-rxbus-e6c940a94bd8
 */

@Singleton
class RxBus {

    /** RXBUS METHODS __________________________________________________________________________  */

    private val bus = PublishRelay.create<Any>().toSerialized()

    fun asFlowable(): Flowable<Any> {
        return bus.toFlowable(BackpressureStrategy.LATEST)
    }

    /** ACTION METHODS _________________________________________________________________________  */

    fun hasObservers(): Boolean {
        return bus.hasObservers()
    }

    fun send(`object`: Any) {
        bus.accept(`object`)
    }
}