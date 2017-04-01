package com.ivotai.trick.dragger2;

import android.app.Application;

import dagger.internal.Preconditions;

/**
 * The type App component holder.
 */
public class AppComponentHolder {

    private AppComponentHolder() {
    }

    private static AppComponent appComponent;

    /**
     * Init app component.
     *
     * @param application the application
     */
    public static void initAppComponent(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    /**
     * Gets injector.
     *
     * @return the injector
     */
    public static AppComponent getInjector() {
        Preconditions.checkNotNull(appComponent, "appComponent not init");
        return appComponent;
    }

}
