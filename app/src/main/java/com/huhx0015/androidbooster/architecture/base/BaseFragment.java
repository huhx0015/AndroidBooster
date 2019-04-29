package com.huhx0015.androidbooster.architecture.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.huhx0015.androidbooster.application.AndroidApplication;
import com.huhx0015.androidbooster.injections.components.DaggerFragmentComponent;
import com.huhx0015.androidbooster.injections.components.FragmentComponent;
import com.huhx0015.androidbooster.injections.modules.FragmentModule;
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule;
import com.huhx0015.androidbooster.injections.modules.ViewModelModule;

public class BaseFragment extends Fragment {

    /** FRAGMENT LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent().inject(this); // DEPENDENCY INJECTION
    }

    /** DEPENDENCY INJECTION METHODS ___________________________________________________________ **/

    @NonNull
    private FragmentComponent getComponent() {
        return DaggerFragmentComponent.builder()
                .applicationComponent(AndroidApplication.get(getContext())
                        .getComponent())
                .fragmentModule(new FragmentModule(this))
                .recyclerViewModule(new RecyclerViewModule())
                .viewModelModule(new ViewModelModule())
                .build();
    }
}