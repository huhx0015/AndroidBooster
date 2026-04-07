package com.huhx0015.androidbooster.ui.activities.composedata

import com.huhx0015.androidbooster.architecture.mvi.BaseIntent

sealed class ComposeDataIntent : BaseIntent {
    data object LoadData : ComposeDataIntent()
    data object RefreshData : ComposeDataIntent()
    data object LoadMoreData : ComposeDataIntent()
}