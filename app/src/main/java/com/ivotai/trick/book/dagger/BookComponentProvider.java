package com.ivotai.trick.book.dagger;

import com.ivotai.trick.book.view.BookView;
import com.ivotai.trick.main.dagger.MainComponentProvider;

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
        bookComponent = DaggerBookComponent.builder()
                .mainComponent(MainComponentProvider.provide())
                .bookModule(new BookModule(bookView))
                .build();
    }

    /**
     * Gets book component.
     *
     * @return the book component
     */
    public static BookComponent getBookComponent() {
        Preconditions.checkNotNull(bookComponent, "ComponentProvider not init.");
        return bookComponent;
    }

}
