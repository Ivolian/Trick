package com.ivotai.trick.util;

import android.content.Context;

import javax.inject.Inject;


public class DensityUtil {

    private Context context;

    @Inject
    public DensityUtil(Context context) {
        this.context = context;
    }

    public int dip2Px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
