package com.huhx0015.androidbooster.viewmodel

import android.app.Application
import com.huhx0015.androidbooster.architecture.base.BaseViewModel

open class ApiRecyclerViewModel (application: Application) : BaseViewModel(application) {

    /** INITIALIZATION __________________________________________________________________________ */

    init {
        init()
    }

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