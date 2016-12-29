package com.felixsu.dagger2.view.child;

import com.felixsu.dagger2.base.dagger.PerActivity;
import com.felixsu.dagger2.base.dagger.component.AppComponent;
import com.felixsu.dagger2.base.dagger.module.ActivityModule;

import dagger.Component;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ChildActivityComponent {

    void inject(ChildActivity activity);
}
