package com.huhx0015.androidbooster.architecture.event

import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Singleton

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