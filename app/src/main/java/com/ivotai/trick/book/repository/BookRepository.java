package com.ivotai.trick.book.repository;

import com.ivotai.trick.model.Book;

import java.util.List;

import rx.Observable;

public interface BookRepository {

    public Observable<List<Book>> getBooksByPagestamp(int pagestamp);


}
