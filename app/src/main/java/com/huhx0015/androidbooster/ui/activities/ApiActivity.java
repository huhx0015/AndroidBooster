package com.huhx0015.androidbooster.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.huhx0015.androidbooster.architecture.base.BaseActivity;
import javax.inject.Inject;
import retrofit2.Retrofit;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

public class ApiActivity extends BaseActivity {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // DEPENDENCY INJECTION VARIABLES
    @Inject
    Retrofit mNetworkAdapter;

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}