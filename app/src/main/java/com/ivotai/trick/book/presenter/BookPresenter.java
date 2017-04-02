package com.ivotai.trick.book.presenter;

import com.ivotai.trick.base.BasePresenter;
import com.ivotai.trick.book.repository.BookRepository;
import com.ivotai.trick.book.view.BookView;
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
