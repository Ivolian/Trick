package com.ivotai.trick.network.fetcher;

import com.ivotai.trick.model.BookResponse;
import com.ivotai.trick.network.service.BookService;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class BookFetcher {

    private final BookService bookService;

    @Inject
    BookFetcher(BookService bookService) {
        this.bookService = bookService;
    }

    public final Observable<BookResponse> fetch(int pagestamp) {
        return bookService.listBook("categoryV3", ",-1,-1,-1,-1,6", "20001", pagestamp);
    }



}
