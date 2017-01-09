package com.felixsu.dagger2;

import android.app.Application;

import com.felixsu.dagger2.base.dagger.component.AppComponent;
import com.felixsu.dagger2.base.dagger.component.DaggerAppComponent;
import com.felixsu.dagger2.base.dagger.module.AppModule;

import java.text.SimpleDateFormat;
import java.util.Date;

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

        String currentDate = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss").format(new Date());
        mComponent.sharedPreferences().edit().putString("current_date", currentDate).apply();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
