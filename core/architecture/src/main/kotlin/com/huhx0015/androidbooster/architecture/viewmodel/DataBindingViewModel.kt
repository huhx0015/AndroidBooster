package com.huhx0015.androidbooster.architecture.viewmodel

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import com.huhx0015.androidbooster.architecture.base.BaseViewModel

open class DataBindingViewModel(
    application: Application,
    protected val registry: PropertyChangeRegistry
) : BaseViewModel(application), Observable {

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        registry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        registry.remove(callback)
    }

    protected fun notifyChange(propertyId: Int) {
        registry.notifyChange(this, propertyId)
    }

    protected fun notifyChangeAll() {
        registry.notifyChange(this, 0) // 0 = BR._all (notify all properties)
    }
}
