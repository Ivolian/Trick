package com.ivotai.trick.main.dagger;

import com.ivotai.trick.main.view.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainView mainView;

    MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    MainView provideMainView() {
        return mainView;
    }

}
