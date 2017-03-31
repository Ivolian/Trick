package com.ivotai.trick.network;

import com.ivotai.trick.config.GlobalSettings;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Retrofit provider.
 */
@Singleton
public class RetrofitProvider {

    /**
     * Instantiates a new Retrofit provider.
     */
    @Inject
    public RetrofitProvider() {
    }

    /**
     * Provide retrofit.
     *
     * @return the retrofit
     */
    public final Retrofit provide() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if (GlobalSettings.useStetho()) {
//            okHttpClientBuilder.addNetworkInterceptor(new StethoInterceptor());
        }
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(GlobalSettings.baseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
