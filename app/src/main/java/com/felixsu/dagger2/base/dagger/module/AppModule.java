package com.felixsu.dagger2.base.dagger.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.felixsu.dagger2.MyApp;
import com.felixsu.dagger2.model.SharedData;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

@Module
public class AppModule {

    MyApp mApp;

    public AppModule(MyApp app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public MyApp providesApplication() {
        return mApp;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreference(MyApp app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    public SharedData providesSharedData() {
        return new SharedData();
    }
}
