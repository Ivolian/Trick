package com.ivotai.trick.model;

import java.util.List;

public class BookResponse extends BaseResponse<Book> {

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
