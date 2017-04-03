package com.ivotai.trick.book.repository;

import com.ivotai.trick.model.Book;
import com.ivotai.trick.model.BookResponse;
import com.ivotai.trick.book.service.BookService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * The type Book repository.
 */
public class NetworkBookRepository implements BookRepository {

    private final BookService bookService;

    /**
     * Instantiates a new Book repository.
     *
     * @param bookService the book service
     */
    @Inject
    NetworkBookRepository(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Gets books by pagestamp.
     *
     * @param pagestamp the pagestamp
     * @return the books by pagestamp
     */
    public Observable<List<Book>> getBooksByPagestamp(int pagestamp) {
        return bookService.getBooks("categoryV3", ",-1,-1,-1,-1,6", "20001", pagestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(BookResponse::getBookList);
    }

}
