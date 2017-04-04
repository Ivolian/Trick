package com.ivotai.trick.book.view.viewholder;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gelitenight.waveview.library.WaveView;
import com.ivotai.trick.R;
import com.ivotai.trick.app.provider.AppComponentProvider;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderBookViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivGift)
    ImageView ivGift;

    @BindView(R.id.tvCheckIn)
    TextView tvCheckIn;

    public HeaderBookViewHolder(View headerView) {
        super(headerView);
        ButterKnife.bind(this, headerView);
        AppComponentProvider.provide().inject(this);
        initViews();
    }

    private void initViews() {
        initIvGift();
        initTvCheckIn();
        initWaveView();
    }

    private void initWaveView() {
        WaveHelper waveHelper = new WaveHelper(waveView);
        int color = ColorUtils.setAlphaComponent(md_white, 10);
        waveView.setWaveColor(color, color);
        waveHelper.start();
    }

    @BindColor(R.color.md_grey_50)
    int md_grey_50;

    private void initIvGift() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10000);
        gradientDrawable.setStroke(10, ColorUtils.setAlphaComponent(md_grey_50, 100));
        ivGift.setBackground(gradientDrawable);
    }

    @BindColor(R.color.md_white)
    int md_white;
    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.waveView)
    WaveView waveView;

    private void initTvCheckIn() {
        GradientDrawable unpressed = new GradientDrawable();
        unpressed.setCornerRadius(10000);
        unpressed.setStroke(3, md_white);

        GradientDrawable pressed = new GradientDrawable();
        pressed.setCornerRadius(10000);
        pressed.setStroke(3, md_white);
        pressed.setColor(md_white);


        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{-android.R.attr.state_pressed}, unpressed);

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_pressed},
                        new int[]{-android.R.attr.state_pressed}
                },
                new int[]{colorPrimary, md_white}
        );

        tvCheckIn.setTextColor(colorStateList);
        tvCheckIn.setPadding(36, 12, 36, 12);
        tvCheckIn.setBackground(stateListDrawable);
        tvCheckIn.setClickable(true);
    }


}
