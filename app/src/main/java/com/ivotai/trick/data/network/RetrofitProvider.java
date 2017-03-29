package com.ivotai.trick.data.network;

import android.app.Application;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.ivotai.trick.Provider;
import com.ivotai.trick.config.GlobalSettings;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitProvider extends Provider<Retrofit> {

// http://android.reader.qq.com/v6_3_9/listDispatch?action=categoryV3&actionTag=,-1,-1,-1,-1,6&actionId=20001&pagestamp=1
//    http://android.reader.qq.com/v6_3_9/listDispatch?action=categoryV3&actionTag=,-1,-1,-1,-1,6&actionId=20001&pagestamp=1

    private static final String BASE_URL = "http://apis.juhe.cn/train/";

    @Override
    public void init(Application application) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        // add stethoInterceptor
        if (GlobalSettings.useStetho()) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
            builder.client(client);
        }

        Retrofit retrofit = builder.build();
        setToProvide(retrofit);
    }


}
