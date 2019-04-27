package com.huhx0015.androidbooster.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huhx0015.androidbooster.R;
import com.huhx0015.androidbooster.architecture.base.BaseFragment;
import com.huhx0015.androidbooster.viewmodel.ApiRecyclerViewModel;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class ApiFragment extends BaseFragment {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // VIEW VARIABLES
    private View mFragmentView;

    // DEPENDENCY INJECTION VARIABLES
    @Inject
    ApiRecyclerViewModel mViewModel;
    @Inject
    Retrofit mNetworkAdapter;

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.view_api_recyclerview, container, false);
        return mFragmentView;
    }
}