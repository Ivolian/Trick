package com.ivotai.trick.book;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivotai.trick.BookAdapter;
import com.ivotai.trick.BookView;
import com.ivotai.trick.R;
import com.ivotai.trick.base.BaseActivity;
import com.ivotai.trick.model.Book;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;


public class BookActivity extends BaseActivity implements BookView {

    @Override
    protected boolean hideStatusBar() {
        return true;
    }

    @Override
    protected void initDaggerComponent() {
        BookComponentHolder.initBookComponent(this);
        BookComponentHolder.getBookComponent().inject(this);
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

    @Inject
    BookPresenter bookPresenter;


    @Override
    protected void initWorks() {
        final int pagestamp = 1;
        bookPresenter.loadBooks(pagestamp);
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


    BookAdapter bookAdapter;

    private void initRvBookList() {
        rvBookList.setLayoutManager(new LinearLayoutManager(this));
        rvBookList.setAdapter(bookAdapter = new BookAdapter());
    }

    @Override
    public void setProgressIndicator(boolean active) {
        // todo
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
