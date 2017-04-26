package com.akr.arch.di.components;

import android.content.Context;
import com.akr.arch.di.module.ApplicationModule;
import javax.inject.Singleton;
import dagger.Component;
import retrofit2.Retrofit;


/**
 * Created by Omar on 25/04/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();
}
