package com.huhx0015.androidbooster.architecture.mvvm;

public interface BaseContract {

    /** VIEW INTERFACE _________________________________________________________________________ **/

    interface View extends BaseView {}

    /** VIEWMODEL INTERFACE ____________________________________________________________________ **/

    interface ViewModel extends BaseViewModel<View> {}
}