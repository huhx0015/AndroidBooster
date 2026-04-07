package com.huhx0015.androidbooster.ui.activities.composedata

import com.huhx0015.androidbooster.architecture.mvi.BaseEvent

sealed class ComposeDataEvent : BaseEvent {
    data class ShowMessage(val message: String) : ComposeDataEvent()
}