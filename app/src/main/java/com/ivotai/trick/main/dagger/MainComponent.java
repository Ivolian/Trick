package com.ivotai.trick.main.dagger;

import android.content.Context;

import com.ivotai.trick.app.daggar.AppComponent;
import com.ivotai.trick.main.view.MainActivity;
import com.ivotai.trick.main.view.MainView;

import dagger.Component;
import retrofit2.Retrofit;

@MainScope
//@Subcomponent(modules = {MainModule.class, AppModule.class})
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity o);

    MainView provideMainView();

    Context provideContext();

    Retrofit provideRetrofit();

}
