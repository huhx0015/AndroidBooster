package com.huhx0015.androidbooster.injections.modules

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object RecyclerViewModule {

    /** CONSTANTS ______________________________________________________________________________  */

    private const val GRID_LAYOUT_SPAN_COUNT = 8
    private const val LIST_PREFETCH_SIZE = 6

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ActivityScoped
    fun providesGridLayoutManager(@ActivityContext context: Context): GridLayoutManager {
        val layoutManager = GridLayoutManager(context, GRID_LAYOUT_SPAN_COUNT)
        layoutManager.initialPrefetchItemCount = LIST_PREFETCH_SIZE
        return layoutManager
    }

    @Provides
    @ActivityScoped
    fun providesLinearLayoutManager(@ActivityContext context: Context): LinearLayoutManager {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.isItemPrefetchEnabled = true
        layoutManager.initialPrefetchItemCount = LIST_PREFETCH_SIZE
        return layoutManager
    }
}