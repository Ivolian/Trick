package com.ivotai.trick.book.dagger;

import com.ivotai.trick.app.daggar.AppComponent;
import com.ivotai.trick.app.provider.AppComponentProvider;
import com.ivotai.trick.book.view.BookView;

import dagger.internal.Preconditions;



/**
 * The type Book component provider.
 */
public final class BookComponentProvider {

    private BookComponentProvider() {
    }

    private static BookComponent bookComponent;

    /**
     * Init.
     *
     * @param bookView the book view
     */
    public static void init(BookView bookView) {
        AppComponent appComponent = AppComponentProvider.provide();
        BookModule bookModule = new BookModule(bookView);
        bookComponent = DaggerBookComponent.builder()
                .appComponent(appComponent)
                .bookModule(bookModule)
                .build();
    }

    /**
     * Gets book component.
     *
     * @return the book component
     */
    public static BookComponent getBookComponent() {
        Preconditions.checkNotNull(bookComponent, "BookComponentProvider not init.");
        return bookComponent;
    }

}
