package com.felixsu.dagger2.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.felixsu.dagger2.R;
import com.felixsu.dagger2.base.activity.BaseActivity;
import com.felixsu.dagger2.model.SharedData;
import com.felixsu.dagger2.view.child.ChildActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    MainActivityComponent mComponent;
    MainPresenter mPresenter;

    @BindView(R.id.field_1)
    EditText mNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = mComponent.presenter();
    }

    @Override
    protected void injectDependencies() {
        mComponent = DaggerMainActivityComponent.builder()
                .appComponent(getBaseApplication().getComponent())
                .build();

        mComponent.inject(this);
    }

    @OnClick(R.id.button_1)
    public void storeName() {
        String name = mNameField.getText().toString();
        mPresenter.storeName(name);
    }

    @OnClick(R.id.button_2)
    public void goToChild() {
        Intent intent = new Intent(this, ChildActivity.class);
        startActivity(intent);
    }

}
