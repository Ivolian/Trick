package com.ivotai.trick.book.view;

import com.ivotai.trick.base.BaseView;
import com.ivotai.trick.model.Book;

import java.util.List;

/**
 * The interface Book view.
 */
public interface BookView extends BaseView {

    /**
     * Sets progress indicator.
     *
     * @param active the active
     */
    void setProgressIndicator(boolean active);

    /**
     * Show load error.
     */
    void showLoadError();

    /**
     * Render books.
     *
     * @param books the books
     */
    void renderBooks(List<Book> books);

}
