package com.ivotai.trick.book.dagger;

import com.ivotai.trick.book.service.BookService;
import com.ivotai.trick.book.view.BookView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * The type Book module.
 */
@Module
class BookModule {

    private final BookView mBookView;

    /**
     * Instantiates a new Book module.
     *
     * @param bookView the book view
     */
    BookModule(BookView bookView) {
        mBookView = bookView;
    }

    /**
     * Provide book view book view.
     *
     * @return the book view
     */
    @Provides
    BookView provideBookView() {
        return mBookView;
    }

    /**
     * Provide book service book service.
     *
     * @param retrofit the retrofit
     * @return the book service
     */
    @BookScope
    @Provides
    BookService provideBookService(Retrofit retrofit) {
        return retrofit.create(BookService.class);
    }

}
