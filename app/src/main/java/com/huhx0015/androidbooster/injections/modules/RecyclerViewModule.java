package com.huhx0015.androidbooster.injections.modules;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huhx0015.androidbooster.injections.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class RecyclerViewModule {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    private static final int GRID_LAYOUT_SPAN_COUNT = 8;
    private static final int LIST_PREFETCH_SIZE = 6;

    /** MODULE METHODS _________________________________________________________________________ **/

    @Provides
    @ActivityScope
    GridLayoutManager providesGridLayoutManager(@NonNull Context context) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, GRID_LAYOUT_SPAN_COUNT);
        layoutManager.setInitialPrefetchItemCount(LIST_PREFETCH_SIZE);
        return layoutManager;
    }

    @Provides
    @ActivityScope
    LinearLayoutManager providesLinearLayoutManager(@NonNull Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setItemPrefetchEnabled(true);
        layoutManager.setInitialPrefetchItemCount(LIST_PREFETCH_SIZE);
        return layoutManager;
    }
}