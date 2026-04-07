package com.huhx0015.androidbooster.ui.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.huhx0015.androidbooster.model.DataItem
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

private const val KEY_COMPOSE_DATA_COLUMN_LOADING_FOOTER = "compose_data_column_loading_footer"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : DataItem> ComposeDataColumn(
    items: List<T>,
    modifier: Modifier = Modifier,
    isInitialLoading: Boolean = false,
    isRefreshing: Boolean = false,
    isLoadingMore: Boolean = false,
    progressColor: Color = MaterialTheme.colorScheme.primary,
    onRefresh: () -> Unit = {},
    onLoadMore: () -> Unit = {},
    listState: LazyListState = rememberLazyListState(),
    pullToRefreshState: PullToRefreshState = rememberPullToRefreshState(),
    loadMoreBuffer: Int = 2,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    itemContent: @Composable (T) -> Unit
) {
    if (isInitialLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = progressColor)
        }
        return
    }

    LaunchedEffect(listState, items.size, isLoadingMore, loadMoreBuffer) {
        snapshotFlow { listState.shouldLoadMore(loadMoreBuffer) }
            .distinctUntilChanged()
            .filter { shouldLoadMore -> shouldLoadMore && items.isNotEmpty() && !isLoadingMore }
            .collect { onLoadMore() }
    }

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = pullToRefreshState,
        modifier = modifier,
        indicator = {
            PullToRefreshDefaults.Indicator(
                state = pullToRefreshState,
                isRefreshing = isRefreshing,
                color = progressColor
            )
        }
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment
        ) {
            items(
                items = items,
                key = { item -> item.id }
            ) { item ->
                itemContent(item)
            }

            if (isLoadingMore) {
                item(key = KEY_COMPOSE_DATA_COLUMN_LOADING_FOOTER) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = progressColor)
                    }
                }
            }
        }

    }
}

private fun LazyListState.shouldLoadMore(buffer: Int): Boolean {
    val lastVisibleIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: return false
    val totalCount = layoutInfo.totalItemsCount
    return totalCount > 0 && lastVisibleIndex >= totalCount - 1 - buffer
}
