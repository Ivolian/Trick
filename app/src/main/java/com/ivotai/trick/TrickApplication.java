package com.ivotai.trick;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.ivotai.trick.config.GlobalSettings;
import com.ivotai.trick.data.network.RetrofitProvider;
import com.ivotai.trick.data.sqlite.DaoSessionProvider;

public class TrickApplication extends Application {

    private static TrickApplication instance;

    @Override
    public final void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
//        LeakCanary.install(this);
        // 无必要的先后顺序
        initDaoSessionProvider();
        initStetho();
        initRetrofit();
    }

    private DaoSessionProvider daoSessionProvider;

    private void initDaoSessionProvider() {
        daoSessionProvider = new DaoSessionProvider();
        daoSessionProvider.init(instance);
    }

    public static DaoSessionProvider getDaoSessionProvider() {
        return instance.daoSessionProvider;
    }

    public static RetrofitProvider getRetrofitProvider() {
        return instance.retrofitProvider;
    }

    private void initStetho() {
        if (GlobalSettings.useStetho()) {
            Stetho.initializeWithDefaults(instance);
        }
    }

    private RetrofitProvider retrofitProvider;

    private void initRetrofit() {
        retrofitProvider = new RetrofitProvider();
        retrofitProvider.init(instance);
    }
}
