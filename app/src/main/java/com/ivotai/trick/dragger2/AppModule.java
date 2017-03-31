package com.ivotai.trick.dragger2;

import android.app.Application;
import android.content.Context;

import com.ivotai.trick.TrickApplication;
import com.ivotai.trick.network.RetrofitProvider;
import com.ivotai.trick.network.service.BookService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
class AppModule {

    private final TrickApplication trickApplication;

    AppModule(TrickApplication trickApplication) {
        this.trickApplication = trickApplication;
    }

    @Provides
    Application provideApplication() {
        return trickApplication;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return trickApplication.getApplicationContext();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }

    @Singleton
    @Provides
    BookService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookService.class);
    }

}
