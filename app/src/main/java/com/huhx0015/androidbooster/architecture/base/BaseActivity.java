package com.huhx0015.androidbooster.architecture.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.huhx0015.androidbooster.application.AndroidApplication;
import com.huhx0015.androidbooster.injections.components.ActivityComponent;
import com.huhx0015.androidbooster.injections.components.DaggerActivityComponent;
import com.huhx0015.androidbooster.injections.modules.ActivityModule;
import com.huhx0015.androidbooster.injections.modules.RecyclerViewModule;
import com.huhx0015.androidbooster.injections.modules.ViewModelModule;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // DEPENDENCY INJECTION VARIABLES
    @Inject
    CompositeDisposable mDisposable;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this); // DEPENDENCY INJECTION
    }

    /** DEPENDENCY INJECTION METHODS ___________________________________________________________ **/

    @NonNull
    private ActivityComponent getComponent() {
        return DaggerActivityComponent.builder()
                .applicationComponent(AndroidApplication.get(this).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .recyclerViewModule(new RecyclerViewModule())
                .viewModelModule(new ViewModelModule())
                .build();
    }

    /** FRAGMENT METHODS _______________________________________________________________________ **/

    @Nullable
    protected Fragment getFragment(@NonNull String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }
}