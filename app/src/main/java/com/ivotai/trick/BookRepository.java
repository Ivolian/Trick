package com.ivotai.trick;

import com.ivotai.trick.model.Book;
import com.ivotai.trick.model.BookResponse;
import com.ivotai.trick.book.BookService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class BookRepository {

    private final BookService bookService;

    @Inject
    public BookRepository(BookService bookService) {
        this.bookService = bookService;
    }

    public Observable<List<Book>> getBooksByPagestamp(int pagestamp) {
        return bookService.listBook("categoryV3", ",-1,-1,-1,-1,6", "20001", pagestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(BookResponse::getBookList);
    }

}
