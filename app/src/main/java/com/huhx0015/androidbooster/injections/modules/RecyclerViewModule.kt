package com.huhx0015.androidbooster.injections.modules

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.huhx0015.androidbooster.injections.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class RecyclerViewModule {

    /** CONSTANTS ______________________________________________________________________________  */

    companion object {
        private const val GRID_LAYOUT_SPAN_COUNT = 8
        private const val LIST_PREFETCH_SIZE = 6
    }

    /** MODULE METHODS _________________________________________________________________________  */

    @Provides
    @ActivityScope
    fun providesGridLayoutManager(context: Context): GridLayoutManager {
        val layoutManager = GridLayoutManager(context, GRID_LAYOUT_SPAN_COUNT)
        layoutManager.initialPrefetchItemCount = LIST_PREFETCH_SIZE
        return layoutManager
    }

    @Provides
    @ActivityScope
    fun providesLinearLayoutManager(context: Context): LinearLayoutManager {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.isItemPrefetchEnabled = true
        layoutManager.initialPrefetchItemCount = LIST_PREFETCH_SIZE
        return layoutManager
    }
}