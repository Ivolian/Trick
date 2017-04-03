package com.ivotai.trick.book.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivotai.trick.R;
import com.ivotai.trick.base.BaseActivity;
import com.ivotai.trick.book.dagger.BookComponentHolder;
import com.ivotai.trick.book.presenter.BookPresenter;
import com.ivotai.trick.book.view.adapter.BookAdapter;
import com.ivotai.trick.model.Book;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;


public class BookActivity extends BaseActivity implements BookView {

    @Override
    protected boolean needHideStatusBar() {
        return true;
    }

    @Override
    protected void injectDependency() {
        BookComponentHolder.initBookComponent(this);
        BookComponentHolder.getBookComponent().inject(this);
    }

    @Override
    protected final int layoutResID() {
        return R.layout.act_book;
    }

    @Override
    protected void initViews() {
        initSwipeRefreshLayout();
        initRvBookList();
    }

    @Inject
    BookPresenter bookPresenter;


    @Override
    protected void initWorks() {
        bookPresenter.loadBooks(1);
    }

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            bookPresenter.loadBooks(1);
        });
    }



    @BindView(R.id.rvBookList)
    RecyclerView rvBookList;

    @BindView(R.id.avi)
    AVLoadingIndicatorView avi;

    private BookAdapter bookAdapter;

    private void initRvBookList() {
        rvBookList.setLayoutManager(new LinearLayoutManager(this));
        rvBookList.setAdapter(bookAdapter = new BookAdapter());
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if (active) {
            avi.show();
        } else {
            avi.hide();
        }
    }

    @Override
    public void showLoadError() {
        // todo
    }

    @Override
    public void renderBooks(List<Book> books) {
        bookAdapter.setHeader(new Object());
        bookAdapter.setItems(books);
        bookAdapter.notifyDataSetChanged();
    }

}
