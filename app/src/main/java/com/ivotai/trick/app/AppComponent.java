package com.ivotai.trick.app;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * The interface App component.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Retrofit provideRetrofit();

}
