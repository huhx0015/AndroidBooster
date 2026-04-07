package com.huhx0015.androidbooster.ui.activities.composedata

import com.huhx0015.androidbooster.architecture.mvi.BaseViewModel
import com.huhx0015.androidbooster.model.PreviewDataItem
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class ComposeDataViewModel : BaseViewModel<ComposeDataState, ComposeDataIntent, ComposeDataEvent>() {

    private val stateFlow = MutableStateFlow(ComposeDataState())
    private val eventChannel = Channel<ComposeDataEvent>(capacity = Channel.BUFFERED)

    override val state: StateFlow<ComposeDataState>
        get() = stateFlow.asStateFlow()
    override val events: Flow<ComposeDataEvent>
        get() = eventChannel.receiveAsFlow()

    companion object {
        private const val VAL_NUMBER_DATA_ITEMS = 10
        private const val VAL_MESSAGE_DATA_REFRESHED = "Data Refreshed"
        private const val VAL_PREVIEW_ITEM = "Preview Item"
    }

    init {
        sendIntent(ComposeDataIntent.LoadData)
    }

    override suspend fun processIntent(intent: ComposeDataIntent) {
        when (intent) {
            is ComposeDataIntent.LoadData -> loadInitialData()
            is ComposeDataIntent.LoadMoreData -> loadMoreData()
            is ComposeDataIntent.RefreshData -> refreshData()
        }
    }

    private fun loadInitialData() {
        if (stateFlow.value.items.isNotEmpty()) {
            return
        }

        stateFlow.value = stateFlow.value.copy(
            items = buildPreviewItems(startId = 1L, count = 10),
            isInitialLoading = false
        )
    }

    private fun loadMoreData() {
        val currentState = stateFlow.value
        if (currentState.isLoadingMore || currentState.isInitialLoading) {
            return
        }

        stateFlow.value = currentState.copy(isLoadingMore = true)

        val nextStartId = (currentState.items.maxOfOrNull { item -> item.id } ?: 0L) + 1L
        val nextItems = buildPreviewItems(startId = nextStartId, count = VAL_NUMBER_DATA_ITEMS)

        stateFlow.value = stateFlow.value.copy(
            items = stateFlow.value.items + nextItems,
            isLoadingMore = false
        )
    }

    private suspend fun refreshData() {
        stateFlow.value = stateFlow.value.copy(isRefreshing = true)

        stateFlow.value = stateFlow.value.copy(
            items = buildPreviewItems(startId = 1L, count = VAL_NUMBER_DATA_ITEMS),
            isRefreshing = false,
            isInitialLoading = false
        )
        eventChannel.send(ComposeDataEvent.ShowMessage(VAL_MESSAGE_DATA_REFRESHED))
    }

    private fun buildPreviewItems(startId: Long, count: Int): List<PreviewDataItem> =
        List(count) { index ->
            val id = startId + index
            PreviewDataItem(
                id = id,
                label = "$VAL_PREVIEW_ITEM #$id"
            )
        }
}