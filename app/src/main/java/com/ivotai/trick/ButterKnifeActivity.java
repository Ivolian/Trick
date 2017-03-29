package com.ivotai.trick;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class ButterKnifeActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResID());
        ButterKnife.bind(this);
        init();
    }

    protected abstract int layoutResID();

    protected void init() {
        // do nothing
    }

}
