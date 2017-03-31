package com.ivotai.trick.dragger2;

import com.ivotai.trick.ui.NovelActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface App component.
 * 注入器
 */
@Singleton
@Component(modules = {AppModule.class})
 public interface AppComponent {
    /**
     * Inject.
     *
     * @param novelActivity the novel activity
     */
    void inject(NovelActivity novelActivity);

}
