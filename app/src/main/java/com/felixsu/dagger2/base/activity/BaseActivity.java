package com.felixsu.dagger2.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.felixsu.dagger2.MyApp;

import butterknife.ButterKnife;
import icepick.Icepick;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        injectDependencies();
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    protected void injectDependencies() {

    }

    public MyApp getBaseApplication() {
        return (MyApp) getApplication();
    }
}
