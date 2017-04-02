package com.ivotai.trick.book;

import com.ivotai.trick.BookView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class BookModule {

    private final BookView bookView;

    public BookModule(BookView bookView) {
        this.bookView = bookView;
    }

    @Provides
    BookView provideBookView() {
        return bookView;
    }

    @Provides
    BookService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookService.class);
    }

}
