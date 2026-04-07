package com.huhx0015.androidbooster.ui.activities.apirecyclerview

import android.app.Application
import androidx.databinding.PropertyChangeRegistry
import com.huhx0015.androidbooster.architecture.viewmodel.DataBindingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class ApiRecyclerViewModel @Inject constructor(
    application: Application,
    registry: PropertyChangeRegistry
) : DataBindingViewModel(application, registry) {

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