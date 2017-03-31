package com.ivotai.trick;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.ivotai.trick.config.GlobalSettings;
import com.ivotai.trick.dragger2.AppComponentWrapper;

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
        AppComponentWrapper.init(this);
//        LeakCanary.install(this);
        initStetho();
    }

    private void initStetho() {
        if (GlobalSettings.useStetho()) {
            Stetho.initializeWithDefaults(this);
        }
    }

}
