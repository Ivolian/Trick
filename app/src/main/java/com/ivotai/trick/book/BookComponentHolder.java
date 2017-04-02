package com.ivotai.trick.book;

import com.ivotai.trick.BookView;
import com.ivotai.trick.app.AppComponentHolder;

import dagger.internal.Preconditions;

public class BookComponentHolder {

    private BookComponentHolder() {
    }

    private static BookComponent bookComponent;

    public static void initBookComponent(BookView bookView) {
        bookComponent = DaggerBookComponent.builder()
                .appComponent(AppComponentHolder.getAppComponent())
                .bookModule(new BookModule(bookView))
                .build();
    }

    public static BookComponent getBookComponent() {
        Preconditions.checkNotNull(bookComponent, "Component need to be initialized.");
        return bookComponent;
    }

}
