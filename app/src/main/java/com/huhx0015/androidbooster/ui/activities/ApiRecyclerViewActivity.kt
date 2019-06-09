package com.huhx0015.androidbooster.ui.activities

import android.os.Bundle
import com.huhx0015.androidbooster.R
import com.huhx0015.androidbooster.architecture.base.BaseActivity
import com.huhx0015.androidbooster.viewmodel.ApiRecyclerViewModel
import javax.inject.Inject
import retrofit2.Retrofit

class ApiRecyclerViewActivity : BaseActivity() {

    /** CLASS VARIABLES ________________________________________________________________________  */

    // DEPENDENCY INJECTION VARIABLES
    @Inject
    lateinit var viewModel: ApiRecyclerViewModel
    @Inject
    lateinit var networkAdapter: Retrofit

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________  */

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_api_recyclerview)
    }
}