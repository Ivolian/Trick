package com.ivotai.trick.book.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ivotai.trick.R;
import com.ivotai.trick.book.dagger.BookComponentProvider;
import com.ivotai.trick.book.presenter.BookPresenter;
import com.ivotai.trick.book.view.adapter.BookAdapter;
import com.ivotai.trick.model.Book;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;


public class BookFragment extends Fragment implements BookView {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookComponentProvider.init(this);
        BookComponentProvider.getBookComponent().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.act_book, container, false);
        ButterKnife.bind(this, root);
        initViews();
        initWorks();
        return root;
    }


    protected void initViews() {
        initSwipeRefreshLayout();
        initRvBookList();
    }

    @Inject
    BookPresenter bookPresenter;

    @BindView(R.id.llTitleBar)
    LinearLayout llTitleBar;


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
        rvBookList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBookList.setAdapter(bookAdapter = new BookAdapter());
        addScrollWatcher();
    }

    private void addScrollWatcher() {
        BookListScrollWatcher bookListScrollWatcher = new BookListScrollWatcher(rvBookList, llTitleBar);
        bookListScrollWatcher.watch();
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