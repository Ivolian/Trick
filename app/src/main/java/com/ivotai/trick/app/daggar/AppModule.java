package com.ivotai.trick.app.daggar;

import android.app.Application;
import android.content.Context;

import com.ivotai.trick.app.provider.RetrofitProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * APP层依赖提供者
 * 提供: Context，Retrofit
 */
@Module
public class AppModule {

    private final Context context;

    /**
     * Instantiates a new App module.
     *
     * @param application the application
     */
    public AppModule(Application application) {
        context = application.getApplicationContext();
    }

    /**
     * Provide context context.
     *
     * @return the context
     */
    @Provides
    Context provideContext() {
        return context;
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
