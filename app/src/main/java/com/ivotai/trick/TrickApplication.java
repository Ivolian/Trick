package com.ivotai.trick;

import android.app.Application;

import com.ivotai.trick.app.AppComponentHolder;

/**
 * The type Trick application.
 */
public class TrickApplication extends Application {

    @Override
    public final void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        AppComponentHolder.initAppComponent(this);
//        Stetho.initializeWithDefaults(this);
//        LeakCanary.install(this);
    }

}
