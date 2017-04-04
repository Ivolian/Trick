package com.ivotai.trick.main.dagger;

import com.ivotai.trick.app.provider.AppComponentProvider;
import com.ivotai.trick.main.view.MainView;

import dagger.internal.Preconditions;


public final class MainComponentProvider {

    private MainComponentProvider() {
    }

    private static MainComponent mainComponent;

    public static void init(MainView mainView) {
        mainComponent = DaggerMainComponent.builder()
                .appComponent(AppComponentProvider.provide())
                .mainModule(new MainModule(mainView))
                .build();
    }

    public static MainComponent provide() {
        Preconditions.checkNotNull(mainComponent, "ComponentProvider not init.");
        return mainComponent;
    }

}
