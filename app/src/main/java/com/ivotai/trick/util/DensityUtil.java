package com.ivotai.trick.util;

import android.content.Context;

public class DensityUtil {


    public static final int dip2Px(Context context,float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
