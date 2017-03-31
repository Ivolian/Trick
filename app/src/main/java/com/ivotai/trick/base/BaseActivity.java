package com.ivotai.trick.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import qiu.niorgai.StatusBarCompat;

/**
 * The type Base activity.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (hideStatusBar()) {
            StatusBarCompat.translucentStatusBar(this);
        }

        setContentView(layoutResID());
        ButterKnife.bind(this);

        injectDependency();

        initViews();
        initWorks();
    }

    /**
     * Layout res id int.
     *
     * @return the int
     */
    protected abstract int layoutResID();


    /**
     * Inject dependency.
     */
    protected void injectDependency() {

    }

    /**
     * Init views.
     */
    protected void initViews() {

    }

    /**
     * Init works.
     */
    protected void initWorks() {

    }


    protected boolean hideStatusBar() {
        return false;
    }

}
