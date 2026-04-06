package com.huhx0015.androidbooster.architecture.viewmodel

import android.app.Application
import com.huhx0015.androidbooster.architecture.base.BaseViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class RxViewModel(
    application: Application,
    protected val disposable: CompositeDisposable
) : BaseViewModel(application) {

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}
