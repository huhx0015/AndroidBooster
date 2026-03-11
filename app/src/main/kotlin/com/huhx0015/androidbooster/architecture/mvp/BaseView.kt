package com.huhx0015.androidbooster.architecture.mvp

interface BaseView<T> {

    /** VIEW INTERFACE _________________________________________________________________________  */

    fun setPresenter(presenter: T)
}