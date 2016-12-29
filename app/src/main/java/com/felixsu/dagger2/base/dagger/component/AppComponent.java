package com.felixsu.dagger2.base.dagger.component;

import android.content.SharedPreferences;

import com.felixsu.dagger2.base.dagger.module.AppModule;
import com.felixsu.dagger2.model.SharedData;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    SharedPreferences sharedPreferences();

    SharedData sharedData();

}
