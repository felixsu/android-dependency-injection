package com.felixsu.dagger2.view.main;

import com.felixsu.dagger2.model.SharedData;

import javax.inject.Inject;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

public class MainPresenter {

    private SharedData mSharedData;

    @Inject
    public MainPresenter(SharedData sharedData) {
        mSharedData = sharedData;
    }

    public void storeName(String name) {
        mSharedData.putName(name);
    }


}
