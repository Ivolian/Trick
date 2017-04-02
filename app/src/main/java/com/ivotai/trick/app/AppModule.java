package com.ivotai.trick.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
class AppModule {

    private final Application application;

    AppModule(Application application) {
        this.application = application;
    }

//    @Provides
//    Application provideApplication() {
//        return application;
//    }


//    @Provides
//    Context provideContext() {
//        return application.getApplicationContext();
//    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }




}
