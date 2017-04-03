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

        if (needTranslucentStatusBar()) {
            StatusBarCompat.translucentStatusBar(this);
        }

        // bind views
        setContentView(layoutResID());
        ButterKnife.bind(this);

        // use injector
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

    /**
     * Need translucent status bar boolean.
     *
     * @return the boolean
     */
    protected boolean needTranslucentStatusBar() {
        return false;
    }

}
