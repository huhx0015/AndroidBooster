package com.huhx0015.androidbooster.logging

import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    /** LOGGING METHODS ________________________________________________________________________  */

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {}
}