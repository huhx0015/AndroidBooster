package com.huhx0015.androidbooster.injections.components;

import com.huhx0015.androidbooster.injections.modules.ApplicationModule;
import com.huhx0015.androidbooster.injections.modules.NetworkModule;
import com.huhx0015.androidbooster.ui.activities.ApiActivity;
import com.huhx0015.androidbooster.ui.fragments.ApiFragment;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Michael Yoon Huh on 6/22/2017.
 */

@Singleton
@Component(modules={ApplicationModule.class, NetworkModule.class})
public interface NetworkComponent {
    void inject(ApiActivity activity);
    void inject(ApiFragment fragment);
}
