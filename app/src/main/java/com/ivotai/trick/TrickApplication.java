package com.ivotai.trick;

import android.app.Application;

import com.ivotai.trick.config.GlobalSettings;
import com.ivotai.trick.dragger2.AppComponentHolder;

/**
 * The type Trick application.
 */
public class TrickApplication extends Application {

    @Override
    public final void onCreate() {
        super.onCreate();
        initWorks();
    }

    private void initWorks() {
        AppComponentHolder.initAppComponent(this);
//        LeakCanary.install(this);
//        initStetho();
    }

    private void initStetho() {
        if (GlobalSettings.useStetho()) {
//            Stetho.initializeWithDefaults(this);
        }
    }

}
