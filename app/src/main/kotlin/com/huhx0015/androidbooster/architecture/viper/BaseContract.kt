package com.huhx0015.androidbooster.architecture.viper

/**
 * Reference: https://cheesecakelabs.com/blog/using-viper-architecture-android/
 */

interface BaseContract {

    /** VIEW INTERFACE _________________________________________________________________________  */

    interface View

    /** INTERACTOR INTERFACE ___________________________________________________________________  */

    interface Interactor

    interface InteractorOutput

    /** PRESENTER INTERFACE ____________________________________________________________________  */

    interface Presenter

    /** ENTITY INTERFACE _______________________________________________________________________  */

    interface Entity

    /** ROUTER INTERFACE _______________________________________________________________________  */

    interface Router
}