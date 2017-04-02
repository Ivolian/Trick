package com.ivotai.trick.book.dagger;

import com.ivotai.trick.app.AppComponent;
import com.ivotai.trick.app.AppComponentHolder;
import com.ivotai.trick.book.view.BookView;

import dagger.internal.Preconditions;

import static com.ivotai.trick.book.dagger.DaggerBookComponent.*;

/**
 * The type Book component holder.
 * 负责BookComponent的初始化和持有
 */
public final class BookComponentHolder {

    private BookComponentHolder() {
    }

    private static BookComponent bookComponent;

    /**
     * Init book component.
     *
     * @param bookView the book view
     */
    public static void initBookComponent(BookView bookView) {
        AppComponent appComponent = AppComponentHolder.getAppComponent();
        BookModule bookModule = new BookModule(bookView);
        bookComponent = builder()
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
        Preconditions.checkNotNull(bookComponent, "Component need to be initialized.");
        return bookComponent;
    }

}
