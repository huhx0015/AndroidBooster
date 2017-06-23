package com.huhx0015.androidbooster.viewmodel;

import android.support.annotation.NonNull;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

public class RecyclerViewModel extends BaseViewModel {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // TEXT VARIABLES
    private String mErrorText;

    // VISIBILITY VARIABLES
    private boolean mErrorVisibility = false;
    private boolean mProgressBarVisibility = false;
    private boolean mRecyclerViewVisibility = false;

    /** GET METHODS ____________________________________________________________________________ **/

    public boolean getErrorVisible() {
        return mErrorVisibility;
    }

    public boolean getProgressBarVisible() {
        return mProgressBarVisibility;
    }

    public boolean getRecyclerViewVisible() {
        return mRecyclerViewVisibility;
    }

    @NonNull
    public String getErrorText() {
        return mErrorText;
    }

    /** SET METHODS ____________________________________________________________________________ **/

    public void setProgressBarVisible(boolean visible) {
        this.mProgressBarVisibility = visible;
        notifyChange();
    }

    public void setRecyclerViewVisible(boolean visible) {
        this.mRecyclerViewVisibility = visible;
        notifyChange();
    }

    public void setErrorVisible(boolean visible) {
        this.mErrorVisibility = visible;
        notifyChange();
    }

    public void setErrorText(@NonNull String text) {
        this.mErrorText = text;
        notifyChange();
    }
}
