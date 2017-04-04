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
import com.ivotai.trick.book.view.viewholder.HeaderBookViewHolder;
import com.ivotai.trick.model.Book;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BookFragment extends Fragment implements BookView {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookComponentProvider.init(this);
        BookComponentProvider.getBookComponent().inject(this);

    }

    public static HeaderBookViewHolder headerBookViewHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fra_book, container, false);
        ButterKnife.bind(this, root);
        initViews();
        initWorks();
        return root;
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser){
//            if (headerBookViewHolder != null) {
//                headerBookViewHolder.zoom();
//            }
//        }
//    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            //TODO now visible to user
        } else {
            if (headerBookViewHolder != null) {
                headerBookViewHolder.zoom();
            }
        }
    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        if (headerBookViewHolder != null) {
//            headerBookViewHolder.zoom();
//        }
//    }

    @OnClick(R.id.ivTitleBarAvator)
    public void onAvatorClicked() {
        bookPresenter.onAvatorClicked();
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

    @Inject
    ItemDecoration itemDecoration;

    private void initRvBookList() {
        rvBookList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBookList.setAdapter(bookAdapter = new BookAdapter());
        rvBookList.addItemDecoration(itemDecoration);
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
        bookAdapter.setHeader(books.get(0));
        bookAdapter.setItems(books.subList(1, books.size()));
        bookAdapter.notifyDataSetChanged();
    }

}
