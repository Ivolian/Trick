package com.ivotai.trick.app;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Retrofit provider.
 * 完成 Retrofit 的初始化工作
 */

class RetrofitProvider {

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
    final Retrofit provide() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
//            okHttpClientBuilder.addNetworkInterceptor(new StethoInterceptor());
        OkHttpClient okHttpClient = okHttpClientBuilder.build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(AppConfig.baseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
