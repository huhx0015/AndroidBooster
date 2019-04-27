package com.huhx0015.androidbooster.architecture.mvp;

/**
 * Reference: https://www.codeproject.com/Articles/1098822/Learn-Android-MVP-Pattern-By-Example
 */

public interface BaseContract {

    /** VIEW INTERFACE _________________________________________________________________________ **/

    // View: Defines the methods that the concrete View aka Fragment will implement. This way you can
    // proceed to create and test the Presenter without worrying about Android-specific components
    // such as Context.
    interface View extends BaseView<Presenter> {}

    /** PRESENTER INTERFACE ____________________________________________________________________ **/

    // Presenter: Defines the methods that the concrete Presenter class will implement. Also known
    // as user actions, this is where the business logic for the app is defined.
    interface Presenter extends BasePresenter {}

    /** REPOSITORY INTERFACE ___________________________________________________________________ **/

    // Repository: Defines the methods that the concrete persistence class will implement. This way
    // the Presenter does not need to be concerned about how data is persisted.
    interface Repository {}
}