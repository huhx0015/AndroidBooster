package com.huhx0015.androidbooster.architecture.mvi

interface BaseContract {

    /** VIEW INTERFACE _________________________________________________________________________  */

    interface View : BaseView

    /** VIEWMODEL INTERFACE ____________________________________________________________________  */

    interface ViewModel : BaseViewModel<View>
}