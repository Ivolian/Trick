package com.ivotai.trick.app.provider;

import android.app.Application;

import com.ivotai.trick.app.daggar.AppComponent;
import com.ivotai.trick.app.daggar.AppModule;
import com.ivotai.trick.app.daggar.DaggerAppComponent;

import dagger.internal.Preconditions;

/**
 * The type App component provider.
 */
public final class AppComponentProvider {

    private AppComponentProvider() {
    }

    private static AppComponent appComponent;

    /**
     * Init.
     *
     * @param application the application
     */
    public static void init(Application application) {
        AppModule appModule = new AppModule(application);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }

    /**
     * Provide app component.
     *
     * @return the app component
     */
    public static AppComponent provide() {
        Preconditions.checkNotNull(appComponent, "AppComponentProvider not init.");
        return appComponent;
    }

}
