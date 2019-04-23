package com.huhx0015.androidbooster.architecture.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.huhx0015.androidbooster.application.AndroidApplication;
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
        ((AndroidApplication) getApplication()).getApplicationComponent().inject(this);
    }
}