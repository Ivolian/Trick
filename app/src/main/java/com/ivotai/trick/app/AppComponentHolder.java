package com.ivotai.trick.app;

import android.app.Application;

import dagger.internal.Preconditions;

/**
 * The type App component holder.
 * 负责AppComponent的初始化和持有
 */
public final class AppComponentHolder {

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
        Preconditions.checkNotNull(appComponent, "Component need to be initialized.");
        return appComponent;
    }

}
