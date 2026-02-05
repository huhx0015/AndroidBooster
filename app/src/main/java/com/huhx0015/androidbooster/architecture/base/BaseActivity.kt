package com.huhx0015.androidbooster.architecture.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    /** CLASS VARIABLES ________________________________________________________________________  */

    @Inject
    lateinit var disposable: CompositeDisposable

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________  */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /** FRAGMENT METHODS _______________________________________________________________________  */

    protected fun getFragment(tag: String): Fragment? {
        return supportFragmentManager.findFragmentByTag(tag)
    }
}