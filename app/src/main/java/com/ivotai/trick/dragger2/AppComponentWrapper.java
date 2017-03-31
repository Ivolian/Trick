package com.ivotai.trick.dragger2;

import com.ivotai.trick.TrickApplication;
import com.ivotai.trick.exception.NotInitException;

/**
 * The type App component wrapper.
 */
public class AppComponentWrapper {

    private static AppComponent appComponent;

    /**
     * Init.
     *
     * @param trickApplication the trick application
     */
    public static void init(TrickApplication trickApplication) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(trickApplication))
                .build();
    }

    /**
     * Gets injector.
     *
     * @return the injector
     */
    public static AppComponent getInjector() {
        if (appComponent == null) {
            throw new NotInitException("appComponent need init first");
        }
        return appComponent;
    }

}
