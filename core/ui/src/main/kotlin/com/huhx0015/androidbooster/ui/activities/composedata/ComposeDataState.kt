package com.huhx0015.androidbooster.ui.activities.composedata

import com.huhx0015.androidbooster.architecture.mvi.BaseState
import com.huhx0015.androidbooster.model.PreviewDataItem

data class ComposeDataState(
    val items: List<PreviewDataItem> = emptyList(),
    val isInitialLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val isLoadingMore: Boolean = false
) : BaseState