package com.felixsu.dagger2.base.dagger.module;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import com.felixsu.dagger2.MyApp;
import com.felixsu.dagger2.base.dagger.PerActivity;
import com.felixsu.dagger2.model.MyDate;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

@Module
public class ActivityModule {

    Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @Named("my_list")
    ArrayAdapter<String> provideArrayAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity, android.R.layout.simple_list_item_1, android.R.id.text1);
        //imagine u're using recycler view adapter, u can put your configuration here
        return adapter;
    }

    @Provides
    @PerActivity
    MyDate provides(SharedPreferences preferences) {
        return new MyDate(preferences.getString("current_date", "oops no date"));
    }
}
