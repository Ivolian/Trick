package com.ivotai.trick.app;

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
        AppModule appModule = new AppModule(application);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }

    /**
     * Gets app component.
     *
     * @return the app component
     */
    public static AppComponent getAppComponent() {
        Preconditions.checkNotNull(appComponent, "component need init");
        return appComponent;
    }

}
