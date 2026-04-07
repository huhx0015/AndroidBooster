package com.huhx0015.androidbooster.model

/**
 * Lightweight model used by UI preview composables.
 */
data class PreviewDataItem(
    override val id: Long,
    val label: String
) : DataItem
