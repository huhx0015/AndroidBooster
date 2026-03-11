package com.huhx0015.androidbooster.viewmodel

import android.app.Application
import com.huhx0015.androidbooster.architecture.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class ApiRecyclerViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {

    /** CLASS VARIABLES ________________________________________________________________________  */

    // TEXT VARIABLES
    var errorText: String? = null
        set (text) {
            field = text
            notifyChangeAll()
        }

    // VISIBILITY VARIABLES
    var errorVisible = false
        set (visible) {
            field = visible
            notifyChangeAll()
        }

    var progressBarVisible = false
        set (visible) {
            field = visible
            notifyChangeAll()
        }

    var recyclerViewVisible = false
        set (visible) {
            field = visible
            notifyChangeAll()
        }
}