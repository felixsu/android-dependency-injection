package com.felixsu.dagger2;

import android.app.Application;

import com.felixsu.dagger2.base.dagger.component.AppComponent;
import com.felixsu.dagger2.base.dagger.component.DaggerAppComponent;
import com.felixsu.dagger2.base.dagger.module.AppModule;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

public class MyApp extends Application {

    AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
