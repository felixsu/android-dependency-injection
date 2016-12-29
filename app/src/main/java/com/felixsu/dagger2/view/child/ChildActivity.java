package com.felixsu.dagger2.view.child;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.felixsu.dagger2.R;
import com.felixsu.dagger2.base.activity.BaseActivity;
import com.felixsu.dagger2.model.SharedData;

import javax.inject.Inject;

import butterknife.BindView;

public class ChildActivity extends BaseActivity {

    @BindView(R.id.text_1)
    TextView mNameLabel;

    @Inject
    SharedData mSharedData;

    ChildActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        mNameLabel.setText(mSharedData.getName());
    }

    @Override
    protected void injectDependencies() {
        mComponent = DaggerChildActivityComponent.builder()
                .appComponent(getBaseApplication().getComponent())
                .build();

        mComponent.inject(this);
    }
}
