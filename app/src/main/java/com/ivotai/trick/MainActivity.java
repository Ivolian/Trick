package com.ivotai.trick;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivotai.trick.base.BaseActivity;
import com.ivotai.trick.dragger2.AppComponentHolder;
import com.ivotai.trick.model.Book;
import com.ivotai.trick.model.BookResponse;
import com.ivotai.trick.network.fetcher.BookFetcher;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends BaseActivity {

    @Override
    protected boolean hideStatusBar() {
        return true;
    }

    @Override
    protected void injectDependency() {
        AppComponentHolder.getInjector().inject(this);
    }

    @Override
    protected final int layoutResID() {
        return R.layout.act_main;
    }

    @Override
    protected void initViews() {
        initSwipeRefreshLayout();
        initRvBookList();
    }

    @Override
    protected void initWorks() {
        fetchBooks();
    }

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(() -> swipeRefreshLayout.setRefreshing(false));
    }

    @BindView(R.id.rvBookList)
    RecyclerView rvBookList;

    @Inject
    BookFetcher bookFetcher;

    BookAdapter bookAdapter;

    private void initRvBookList() {
        rvBookList.setLayoutManager(new LinearLayoutManager(this));
        rvBookList.setAdapter(bookAdapter = new BookAdapter());
    }

    private void fetchBooks() {
        bookFetcher.fetch(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(BookResponse::getBookList)
                .subscribe(new Subscriber<List<Book>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Book> bookList) {
                        bookAdapter.setHeader(new Object());
                        bookAdapter.setItems(bookList);
                        bookAdapter.notifyDataSetChanged();
                    }
                });


    }


}
