package com.huhx0015.androidbooster.injections.components;

import com.huhx0015.androidbooster.injections.modules.LocationModule;
import com.huhx0015.androidbooster.injections.scopes.ServiceScope;
import dagger.Component;

@ServiceScope
@Component(modules = {
        LocationModule.class
},
        dependencies = ApplicationComponent.class)
public interface ServiceComponent {}