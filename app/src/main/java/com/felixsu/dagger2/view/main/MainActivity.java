package com.felixsu.dagger2.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.felixsu.dagger2.R;
import com.felixsu.dagger2.base.activity.BaseActivity;
import com.felixsu.dagger2.base.dagger.module.ActivityModule;
import com.felixsu.dagger2.model.MyDate;
import com.felixsu.dagger2.view.child.ChildActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    MainActivityComponent mComponent;
    MainPresenter mPresenter;

    @BindView(R.id.text_1) TextView mDateText;
    @BindView(R.id.field_1) EditText mNameField;

    @Inject MyDate mMyDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = mComponent.presenter();

        mDateText.setText(mMyDate.getCurrentDate());
    }

    @Override
    protected void injectDependencies() {
        mComponent = DaggerMainActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(getBaseApplication().getComponent())
                .build();

        mComponent.inject(this);
    }

    @OnClick(R.id.button_1)
    public void storeName() {
        String name = mNameField.getText().toString();
        if (name == null || name.isEmpty()) {
            name = "no name";
        }
        mPresenter.storeName(name);
    }

    @OnClick(R.id.button_2)
    public void goToChild() {
        Intent intent = new Intent(this, ChildActivity.class);
        startActivity(intent);
    }

}
