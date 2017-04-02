package com.ivotai.trick.dragger2;

import com.ivotai.trick.MainActivity;
import com.ivotai.trick.ui.NovelActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The interface App component.
 */
@Singleton
@Component(modules = {AppModule.class})
 public interface AppComponent {

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(NovelActivity o);

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(MainActivity o);

}
