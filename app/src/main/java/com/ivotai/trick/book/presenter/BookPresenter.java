package com.ivotai.trick.book.presenter;

import com.ivotai.trick.base.BasePresenter;
import com.ivotai.trick.book.dagger.BookScope;
import com.ivotai.trick.book.repository.BookRepository;
import com.ivotai.trick.book.view.BookView;
import com.ivotai.trick.main.view.MainView;
import com.ivotai.trick.model.Book;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * The type Book presenter.
 */

@BookScope
public class BookPresenter implements BasePresenter {

    private final BookRepository bookRepository;

    private final BookView bookView;

    private final MainView mainView;

    /**
     * Instantiates a new Book presenter.
     *
     * @param bookRepository the book repository
     * @param bookView       the book view
     */
    @Inject
    BookPresenter(BookRepository bookRepository, BookView bookView, MainView mainView) {
        this.bookRepository = bookRepository;
        this.bookView = bookView;
        this.mainView = mainView;
    }

    public void onAvatorClicked() {
        mainView.showSideBar();
    }


    public final void loadBooks(int pagestamp) {
        bookView.setProgressIndicator(true);
       Observable observable = bookRepository.getBooksByPagestamp(pagestamp);
               observable .subscribe(new Subscriber<List<Book>>() {
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
