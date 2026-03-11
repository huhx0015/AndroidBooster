package com.huhx0015.androidbooster.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huhx0015.androidbooster.R
import com.huhx0015.androidbooster.architecture.base.BaseFragment
import com.huhx0015.androidbooster.viewmodel.ApiRecyclerViewModel
import javax.inject.Inject
import retrofit2.Retrofit

class ApiRecyclerViewFragment : BaseFragment() {

    /** CLASS VARIABLES ________________________________________________________________________  */

    // VIEW VARIABLES
    private var fragmentView: View? = null

    // DEPENDENCY INJECTION VARIABLES
    @Inject
    lateinit var viewModel: ApiRecyclerViewModel
    @Inject
    lateinit var networkAdapter: Retrofit

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________  */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.view_api_recyclerview, container, false)
        return fragmentView
    }
}