package com.huhx0015.androidbooster.ui.compose.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huhx0015.androidbooster.model.PreviewDataItem
import com.huhx0015.androidbooster.ui.compose.components.ComposeDataColumn

private val columnPreviewItems = List(8) { index ->
    PreviewDataItem(
        id = index.toLong(),
        label = "Column item #${index + 1}"
    )
}

@Preview(showBackground = true, name = "Column - Default")
@Composable
private fun ComposeDataColumnDefaultPreview() {
    ComposeDataColumnPreviewContent(items = columnPreviewItems)
}

@Preview(showBackground = true, name = "Column - Initial Loading")
@Composable
private fun ComposeDataColumnInitialLoadingPreview() {
    ComposeDataColumnPreviewContent(
        items = emptyList(),
        isInitialLoading = true
    )
}

@Preview(showBackground = true, name = "Column - Refreshing")
@Composable
private fun ComposeDataColumnRefreshingPreview() {
    ComposeDataColumnPreviewContent(
        items = columnPreviewItems,
        isRefreshing = true
    )
}

@Preview(showBackground = true, name = "Column - Loading More")
@Composable
private fun ComposeDataColumnLoadingMorePreview() {
    ComposeDataColumnPreviewContent(
        items = columnPreviewItems,
        isLoadingMore = true
    )
}

@Composable
private fun ComposeDataColumnPreviewContent(
    items: List<PreviewDataItem>,
    isInitialLoading: Boolean = false,
    isRefreshing: Boolean = false,
    isLoadingMore: Boolean = false
) {
    MaterialTheme {
        ComposeDataColumn(
            items = items,
            modifier = Modifier.fillMaxSize(),
            isInitialLoading = isInitialLoading,
            isRefreshing = isRefreshing,
            isLoadingMore = isLoadingMore,
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
