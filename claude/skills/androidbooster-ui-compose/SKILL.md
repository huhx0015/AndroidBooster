---
name: androidbooster-ui-compose
description: Compose lazy list components for AndroidBooster. Use when building Compose list UIs with ComposeDataColumn or ComposeDataRow, DataItem models, pull-to-refresh, initial loading, endless pagination, or custom progress indicator colors.
---

# AndroidBooster UI Compose

## Components

Use reusable Compose list components from `core/ui`:

- `com.huhx0015.androidbooster.model.DataItem`
- `com.huhx0015.androidbooster.ui.compose.components.ComposeDataColumn`
- `com.huhx0015.androidbooster.ui.compose.components.ComposeDataRow`

`DataItem` is the shared model contract:

```kotlin
sealed interface DataItem {
    val id: Long
}
```

Any list item model must implement `DataItem` so lazy list keys can use `id`.

## Required state inputs

Pass these state values to either component:

- `items: List<T>` where `T : DataItem`
- `isInitialLoading: Boolean` for first-load/forced-refresh full replacement spinner
- `isRefreshing: Boolean` for pull-to-refresh active state
- `isLoadingMore: Boolean` for pagination footer spinner
- `onRefresh: () -> Unit` for pull-to-refresh action
- `onLoadMore: () -> Unit` for endless-scroll pagination
- `progressColor: Color` for all progress indicators

## Behavior contract

- If `isInitialLoading` is true, list content is replaced with a centered spinner.
- Pull-to-refresh is built in via Material3 pull-to-refresh APIs.
- Endless loading is triggered near list end and calls `onLoadMore`.
- While `isLoadingMore` is true, a loading footer is shown at list end.
- Indicator color is controlled by `progressColor`.

## Usage template

```kotlin
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.huhx0015.androidbooster.ui.compose.components.ComposeDataColumn
import com.huhx0015.androidbooster.model.DataItem

data class UserUiItem(
    override val id: Long,
    val title: String
) : DataItem

@Composable
fun UsersColumn(
    items: List<UserUiItem>,
    isInitialLoading: Boolean,
    isRefreshing: Boolean,
    isLoadingMore: Boolean,
    onRefresh: () -> Unit,
    onLoadMore: () -> Unit
) {
    ComposeDataColumn(
        items = items,
        isInitialLoading = isInitialLoading,
        isRefreshing = isRefreshing,
        isLoadingMore = isLoadingMore,
        onRefresh = onRefresh,
        onLoadMore = onLoadMore,
        progressColor = Color.Magenta
    ) { item ->
        // Render each item
    }
}
```

Use `ComposeDataRow` with the same state contract for horizontal lists.
