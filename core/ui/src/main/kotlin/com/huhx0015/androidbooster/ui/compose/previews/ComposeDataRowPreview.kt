package com.huhx0015.androidbooster.ui.compose.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import com.huhx0015.androidbooster.ui.compose.components.ComposeDataRow

private val rowPreviewItems = List(8) { index ->
    PreviewDataItem(
        id = index.toLong(),
        label = "Item ${index + 1}"
    )
}

@Preview(showBackground = true, widthDp = 360, heightDp = 160, name = "Row - Default")
@Composable
private fun ComposeDataRowDefaultPreview() {
    ComposeDataRowPreviewContent(items = rowPreviewItems)
}

@Preview(showBackground = true, widthDp = 360, heightDp = 160, name = "Row - Initial Loading")
@Composable
private fun ComposeDataRowInitialLoadingPreview() {
    ComposeDataRowPreviewContent(
        items = emptyList(),
        isInitialLoading = true
    )
}

@Preview(showBackground = true, widthDp = 360, heightDp = 160, name = "Row - Refreshing")
@Composable
private fun ComposeDataRowRefreshingPreview() {
    ComposeDataRowPreviewContent(
        items = rowPreviewItems,
        isRefreshing = true
    )
}

@Preview(showBackground = true, widthDp = 360, heightDp = 160, name = "Row - Loading More")
@Composable
private fun ComposeDataRowLoadingMorePreview() {
    ComposeDataRowPreviewContent(
        items = rowPreviewItems,
        isLoadingMore = true
    )
}

@Composable
private fun ComposeDataRowPreviewContent(
    items: List<PreviewDataItem>,
    isInitialLoading: Boolean = false,
    isRefreshing: Boolean = false,
    isLoadingMore: Boolean = false
) {
    MaterialTheme {
        ComposeDataRow(
            items = items,
            modifier = Modifier.fillMaxSize(),
            isInitialLoading = isInitialLoading,
            isRefreshing = isRefreshing,
            isLoadingMore = isLoadingMore,
            contentPadding = PaddingValues(16.dp),
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
    }
}
