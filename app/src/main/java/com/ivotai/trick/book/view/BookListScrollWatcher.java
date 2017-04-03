package com.ivotai.trick.book.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ivotai.trick.R;
import com.ivotai.trick.app.AppComponentHolder;
import com.ivotai.trick.util.DensityUtil;

import javax.inject.Inject;

public class BookListScrollWatcher {


    private final RecyclerView rvBookList;

    private final LinearLayout llTitleBar;

    public BookListScrollWatcher(RecyclerView rvBookList, LinearLayout llTitleBar) {
        this.rvBookList = rvBookList;
        this.llTitleBar = llTitleBar;
        AppComponentHolder.getAppComponent().inject(this);
    }

    private int oldTotalDy = 0;

    private int fadeDuration = 200;

    @Inject
    DensityUtil densityUtil;

    @Inject
    Context context;

    public void watch() {
        int distance = densityUtil.dip2Px(80);
        rvBookList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int totalDy = oldTotalDy + dy;
                if (oldTotalDy < distance && totalDy >= distance) {
                    fadeInTitleBar();
                }
                if (oldTotalDy > distance && totalDy <= distance) {
                    fadeOutTitleBar();
                }
                oldTotalDy = totalDy;

            }
        });
    }


    private void fadeInTitleBar() {
//        ColorUtils.setAlphaComponent()
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(llTitleBar, "alpha", 0f, 1f);
//        objectAnimator.setDuration(fadeDuration);
//        objectAnimator.start();

        int colorPrimary = ContextCompat.getColor(context, R.color.colorPrimary);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 255);
        valueAnimator.setDuration(fadeDuration);
        valueAnimator.addUpdateListener(animation -> {
            int alpha = (int) animation.getAnimatedValue();
            int color = ColorUtils.setAlphaComponent(colorPrimary, alpha);
            llTitleBar.setBackgroundColor(color);
        });
        valueAnimator.start();

    }

    private void fadeOutTitleBar() {
        int colorPrimary = ContextCompat.getColor(context, R.color.colorPrimary);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(255, 0);
        valueAnimator.setDuration(fadeDuration);
        valueAnimator.addUpdateListener(animation -> {
            int alpha = (int) animation.getAnimatedValue();
            int color = ColorUtils.setAlphaComponent(colorPrimary, alpha);
            llTitleBar.setBackgroundColor(color);
        });
        valueAnimator.start();

    }


}
