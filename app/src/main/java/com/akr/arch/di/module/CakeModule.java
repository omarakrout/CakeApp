package com.akr.arch.di.module;

import com.akr.arch.api.CakeApiService;
import com.akr.arch.di.scope.PerActivity;
import com.akr.arch.mvp.view.MainView;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


/**
 * Created by Omar on 25/04/2017.
 */

@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }
}
