package com.ivotai.trick.book.dagger;

import com.ivotai.trick.book.service.BookService;
import com.ivotai.trick.book.view.BookView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
class BookModule {

    private final BookView bookView;

    BookModule(BookView bookView) {
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
