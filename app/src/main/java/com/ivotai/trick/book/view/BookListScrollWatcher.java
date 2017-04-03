package com.ivotai.trick.book.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ivotai.trick.R;
import com.ivotai.trick.app.AppComponentProvider;
import com.ivotai.trick.util.DensityUtil;

import javax.inject.Inject;

/**
 * The type Book list scroll watcher.
 */
class BookListScrollWatcher {

    private final RecyclerView rvBookList;

    private final LinearLayout llTitleBar;

    /**
     * Instantiates a new Book list scroll watcher.
     *
     * @param rvBookList the rv book list
     * @param llTitleBar the ll title bar
     */
    BookListScrollWatcher(RecyclerView rvBookList, LinearLayout llTitleBar) {
        this.rvBookList = rvBookList;
        this.llTitleBar = llTitleBar;
        AppComponentProvider.provide().inject(this);
    }

    /**
     * The Context.
     */
    @Inject
    Context context;

    /**
     * The Density util.
     */
    @Inject
    DensityUtil densityUtil;

    private int oldTotalDy = 0;

    /**
     * Watch.
     */
    void watch() {
        int distance = densityUtil.dip2Px(80);
        rvBookList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int totalDy = oldTotalDy + dy;
                if (oldTotalDy < distance && totalDy >= distance) {
                    fadeTitleBar(true);
                }
                if (oldTotalDy > distance && totalDy <= distance) {
                    fadeTitleBar(false);
                }
                oldTotalDy = totalDy;
            }
        });
    }

    private void fadeTitleBar(boolean fadeIn) {
        int colorPrimary = ContextCompat.getColor(context, R.color.colorPrimary);
        ValueAnimator valueAnimator = fadeIn ? ValueAnimator.ofInt(0, 255) : ValueAnimator.ofInt(255, 0);
        int fadeDuration = 200;
        valueAnimator.setDuration(fadeDuration);
        valueAnimator.addUpdateListener(animation -> {
            int alpha = (int) animation.getAnimatedValue();
            int color = ColorUtils.setAlphaComponent(colorPrimary, alpha);
            llTitleBar.setBackgroundColor(color);
        });
        valueAnimator.start();
    }

}
