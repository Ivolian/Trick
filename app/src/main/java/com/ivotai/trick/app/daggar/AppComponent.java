package com.ivotai.trick.app.daggar;

import android.content.Context;

import com.ivotai.trick.book.view.BookListScrollWatcher;
import com.ivotai.trick.book.view.viewholder.HeaderBookViewHolder;
import com.ivotai.trick.book.view.viewholder.ItemBookViewHolder;
import com.ivotai.trick.ui.NovelActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    Retrofit provideRetrofit();

    void inject(ItemBookViewHolder o);

    void inject(HeaderBookViewHolder o);

    void inject(BookListScrollWatcher o);

    void inject(NovelActivity o);

}
