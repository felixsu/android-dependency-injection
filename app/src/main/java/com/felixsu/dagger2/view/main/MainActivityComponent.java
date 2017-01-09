package com.felixsu.dagger2.view.main;

import com.felixsu.dagger2.base.dagger.PerActivity;
import com.felixsu.dagger2.base.dagger.component.AppComponent;
import com.felixsu.dagger2.base.dagger.module.ActivityModule;
import com.felixsu.dagger2.model.MyDate;

import dagger.Component;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
interface MainActivityComponent {

    MyDate myDate();

    MainPresenter presenter();

    void inject(MainActivity activity);
}
