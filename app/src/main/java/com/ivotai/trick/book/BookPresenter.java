package com.ivotai.trick.book;

import com.ivotai.trick.BasePresenter;
import com.ivotai.trick.BookRepository;
import com.ivotai.trick.BookView;
import com.ivotai.trick.model.Book;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

public class BookPresenter implements BasePresenter {

    private final BookRepository bookRepository;

    private final BookView bookView;

    @Inject
    public BookPresenter(BookRepository bookRepository, BookView bookView) {
        this.bookRepository = bookRepository;
        this.bookView = bookView;
    }

    public void loadBooks(int pagestamp) {
        bookView.setProgressIndicator(true);
        bookRepository.getBooksByPagestamp(pagestamp).subscribe(new Subscriber<List<Book>>() {
            @Override
            public void onCompleted() {
                bookView.setProgressIndicator(false);
            }

            @Override
            public void onError(Throwable e) {
                bookView.showLoadError();
            }

            @Override
            public void onNext(List<Book> bookList) {
                bookView.renderBooks(bookList);
            }
        });
    }

}
