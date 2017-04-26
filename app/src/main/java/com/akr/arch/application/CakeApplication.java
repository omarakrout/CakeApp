package com.akr.arch.application;

import android.app.Application;
import com.akr.arch.di.components.ApplicationComponent;
import com.akr.arch.di.components.DaggerApplicationComponent;
import com.akr.arch.di.module.ApplicationModule;


/**
 * Created by Omar on 25/04/2017.
 */

public class CakeApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "http://www.mocky.io/v2/"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
