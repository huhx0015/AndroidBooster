package com.huhx0015.androidbooster.architecture.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.huhx0015.androidbooster.application.AndroidApplication
import com.huhx0015.androidbooster.injections.components.ActivityComponent
import com.huhx0015.androidbooster.injections.components.DaggerActivityComponent
import com.huhx0015.androidbooster.injections.modules.ActivityModule
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule
import com.huhx0015.androidbooster.injections.modules.ViewModelModule
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity : AppCompatActivity() {

    /** CLASS VARIABLES ________________________________________________________________________  */

    @Inject
    lateinit var disposable: CompositeDisposable

    /** DEPENDENCY INJECTION ___________________________________________________________________  */

    private val component: ActivityComponent
        get() = DaggerActivityComponent.builder()
                .applicationComponent(AndroidApplication.get(this).component)
                .activityModule(ActivityModule(this))
                .recyclerViewModule(RecyclerViewModule())
                .viewModelModule(ViewModelModule())
                .build()

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________  */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this) // DEPENDENCY INJECTION
    }

    /** FRAGMENT METHODS _______________________________________________________________________  */

    protected fun getFragment(tag: String): Fragment? {
        return supportFragmentManager.findFragmentByTag(tag)
    }
}