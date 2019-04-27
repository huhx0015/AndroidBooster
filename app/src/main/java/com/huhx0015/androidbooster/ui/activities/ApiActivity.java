package com.huhx0015.androidbooster.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.huhx0015.androidbooster.R;
import com.huhx0015.androidbooster.architecture.base.BaseActivity;
import com.huhx0015.androidbooster.viewmodel.ApiRecyclerViewModel;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class ApiActivity extends BaseActivity {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // DEPENDENCY INJECTION VARIABLES
    @Inject
    ApiRecyclerViewModel mViewModel;
    @Inject
    Retrofit mNetworkAdapter;

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_api_recyclerview);
    }
}