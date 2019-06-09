package com.huhx0015.androidbooster.architecture.base

import android.app.Application
import android.content.Context
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.huhx0015.androidbooster.application.AndroidApplication
import com.huhx0015.androidbooster.injections.components.ActivityComponent
import com.huhx0015.androidbooster.injections.components.DaggerActivityComponent
import com.huhx0015.androidbooster.injections.modules.ActivityModule
import com.huhx0015.androidbooster.injections.modules.ViewModelModule
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel (application: Application) : AndroidViewModel(application), Observable {

    /** CLASS VARIABLES ________________________________________________________________________  */

    @Inject
    lateinit var disposable: CompositeDisposable
    @Inject
    lateinit var registry: PropertyChangeRegistry

    /** INITIALIZATION METHODS _________________________________________________________________ **/

    fun init() {
        getComponent(getApplication()).inject(this) // DEPENDENCY INJECTION
    }

    /** LIFECYCLE METHODS ______________________________________________________________________  */

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {}

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {}

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {}

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposable.dispose()
        removeOnPropertyChangedCallback(null)
    }

    /** DATABINDING METHODS ____________________________________________________________________  */

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
        registry.notifyChange(this, BR._all)
    }

    /** DEPENDENCY INJECTION METHODS ___________________________________________________________  */

    private fun getComponent(context: Context): ActivityComponent {
        return DaggerActivityComponent.builder()
                .applicationComponent(AndroidApplication.get(context).component)
                .activityModule(ActivityModule(context as AppCompatActivity))
                .viewModelModule(ViewModelModule())
                .build()
    }
}