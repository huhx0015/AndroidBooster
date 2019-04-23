package com.huhx0015.androidbooster.architecture.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.huhx0015.androidbooster.application.AndroidApplication;

public class BaseFragment extends Fragment {

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AndroidApplication) getActivity().getApplication()).getApplicationComponent().inject(this);
    }
}