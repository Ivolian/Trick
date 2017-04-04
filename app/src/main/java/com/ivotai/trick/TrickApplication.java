package com.ivotai.trick;

import android.app.Application;

import com.ivotai.trick.app.provider.AppComponentProvider;


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
        AppComponentProvider.init(this);
//        Stetho.initializeWithDefaults(this);
//        LeakCanary.install(this);
    }

}
