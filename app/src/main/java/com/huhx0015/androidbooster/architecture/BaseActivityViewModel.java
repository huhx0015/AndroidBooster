package com.huhx0015.androidbooster.architecture;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

@Deprecated
public interface BaseActivityViewModel {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
