package com.akr.arch.di.components;

import com.akr.arch.di.module.CakeModule;
import com.akr.arch.di.scope.PerActivity;
import com.akr.arch.mvp.view.activity.home.MainActivity;
import dagger.Component;


/**
 * Created by Omar on 25/04/2017.
 */

@PerActivity
@Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {

    void inject(MainActivity activity);
}
