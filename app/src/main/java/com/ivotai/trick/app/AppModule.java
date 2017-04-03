package com.ivotai.trick.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * The type App module.
 * 顶级依赖提供者
 * 提供: Context，Retrofit
 */
@Module
class AppModule {

    private final Context mContext;

    /**
     * Instantiates a new App module.
     *
     * @param application the application
     */
    AppModule(Application application) {
        mContext = application.getApplicationContext();
    }

    /**
     * Provide context context.
     *
     * @return the context
     */
    @Provides
    Context provideContext() {
        return mContext;
    }

    /**
     * Provide retrofit retrofit.
     *
     * @param retrofitProvider the retrofit provider
     * @return the retrofit
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }

}
