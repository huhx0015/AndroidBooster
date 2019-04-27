package com.huhx0015.androidbooster.logging;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {

    /** LOGGING METHODS ________________________________________________________________________ **/

    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message,
                       @Nullable Throwable t) {}
}