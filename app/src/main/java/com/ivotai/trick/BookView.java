package com.ivotai.trick;

import com.ivotai.trick.model.Book;

import java.util.List;

public interface BookView extends BaseView {

    void setProgressIndicator(boolean active);

    void showLoadError();

    void renderBooks(List<Book> books);

}
