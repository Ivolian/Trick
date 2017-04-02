package com.ivotai.trick.app;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * The interface App component.
 * 顶级依赖注入器
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    // 暴露 Retrofit 给下级 Component
    Retrofit provideRetrofit();

}
