package com.huhx0015.androidbooster.architecture.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.huhx0015.androidbooster.application.AndroidApplication
import com.huhx0015.androidbooster.injections.components.DaggerFragmentComponent
import com.huhx0015.androidbooster.injections.components.FragmentComponent
import com.huhx0015.androidbooster.injections.modules.FragmentModule
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule
import com.huhx0015.androidbooster.injections.modules.ViewModelModule

open class BaseFragment : Fragment() {

    /** DEPENDENCY INJECTION ___________________________________________________________________  */

    private val component: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .applicationComponent(AndroidApplication.get(context!!).component)
                .fragmentModule(FragmentModule(this))
                .recyclerViewModule(RecyclerViewModule())
                .viewModelModule(ViewModelModule())
                .build()

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________  */

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        component.inject(this) // DEPENDENCY INJECTION
    }
}