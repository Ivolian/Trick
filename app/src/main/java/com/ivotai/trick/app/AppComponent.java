package com.ivotai.trick.app;

import com.ivotai.trick.book.view.BookListScrollWatcher;
import com.ivotai.trick.book.view.viewholder.ItemBookViewHolder;
import com.ivotai.trick.ui.NovelActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * The interface App component.
 * 顶级 injector
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    /**
     * Provide retrofit retrofit.
     *
     * @return the retrofit
     */
// 暴露 Retrofit 给下级 Component
    Retrofit provideRetrofit();

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(ItemBookViewHolder o);

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(BookListScrollWatcher o);

    /**
     * Inject.
     *
     * @param o the o
     */
    void inject(NovelActivity o);

}
