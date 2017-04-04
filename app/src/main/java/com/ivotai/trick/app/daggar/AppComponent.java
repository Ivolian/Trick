package com.ivotai.trick.app.daggar;

import com.ivotai.trick.book.view.BookListScrollWatcher;
import com.ivotai.trick.book.view.viewholder.HeaderBookViewHolder;
import com.ivotai.trick.book.view.viewholder.ItemBookViewHolder;
import com.ivotai.trick.main.MainActivity;
import com.ivotai.trick.ui.NovelActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * The interface App component.
 * APP层依赖注入器，injector
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    /**
     * Provide retrofit retrofit.
     * 将依赖暴露给下级 Component
     * @return the retrofit
     */
    Retrofit provideRetrofit();

    void inject(ItemBookViewHolder o);

    void inject(HeaderBookViewHolder o);

    void inject(BookListScrollWatcher o);

    void inject(NovelActivity o);

    void inject(MainActivity o);

}
