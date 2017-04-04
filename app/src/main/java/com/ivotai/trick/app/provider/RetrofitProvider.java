package com.ivotai.trick.app.provider;

import com.ivotai.trick.app.config.AppConfig;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Retrofit provider.
 */
public class RetrofitProvider {

    /**
     * Instantiates a new Retrofit provider.
     */
    @Inject
    RetrofitProvider() {
    }

    /**
     * Provide retrofit.
     *
     * @return the retrofit
     */
    public final Retrofit provide() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
//            okHttpClientBuilder.addNetworkInterceptor(new StethoInterceptor());
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(AppConfig.BASE_REQUEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
