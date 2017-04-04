package com.ivotai.trick.main.dagger;

import com.ivotai.trick.app.daggar.AppComponent;
import com.ivotai.trick.main.view.MainActivity;

import dagger.Component;

@MainScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity o);

}
