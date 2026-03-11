package com.huhx0015.androidbooster.architecture.mvvm

interface BaseContract {

    /** VIEW INTERFACE _________________________________________________________________________  */

    interface View : BaseView

    /** VIEWMODEL INTERFACE ____________________________________________________________________  */

    interface ViewModel : BaseViewModel<View>
}