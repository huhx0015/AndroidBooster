package com.huhx0015.androidbooster.ui.activities.composedata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huhx0015.androidbooster.model.PreviewDataItem
import com.huhx0015.androidbooster.ui.compose.components.ComposeDataColumn
import com.huhx0015.androidbooster.ui.compose.components.ComposeDataRow

@Composable
fun ComposeDataScreen(
    state: ComposeDataState,
    onIntent: (ComposeDataIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ComposeDataRow(
            items = state.items,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { item ->
            Text(
                text = item.label,
                modifier = Modifier
                    .size(width = 96.dp, height = 48.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(12.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        ComposeDataColumn(
            items = state.items,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            isInitialLoading = state.isInitialLoading,
            isRefreshing = state.isRefreshing,
            isLoadingMore = state.isLoadingMore,
            onRefresh = { onIntent(ComposeDataIntent.RefreshData) },
            onLoadMore = { onIntent(ComposeDataIntent.LoadMoreData) },
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) { item ->
            Text(
                text = item.label,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(12.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private val composeDataScreenPreviewItems = List(10) { index ->
    PreviewDataItem(
        id = index.toLong(),
        label = "Preview item #${index + 1}"
    )
}

@Preview(showBackground = true, name = "ComposeDataScreen")
@Composable
private fun ComposeDataScreenPreview() {
    MaterialTheme {
        ComposeDataScreen(
            state = ComposeDataState(
                items = composeDataScreenPreviewItems,
                isInitialLoading = false,
                isRefreshing = false,
                isLoadingMore = false
            ),
            onIntent = {}
        )
    }
}
