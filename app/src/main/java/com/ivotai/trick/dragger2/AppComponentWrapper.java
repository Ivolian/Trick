package com.ivotai.trick.dragger2;

import com.ivotai.trick.TrickApplication;

import dagger.internal.Preconditions;

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
        Preconditions.checkNotNull(appComponent, "appComponent is not init.");
        return appComponent;
    }

}
