package com.ivotai.trick.util;

import android.content.Context;

/**
 * The type Density util.
 */
public class DensityUtil {

    private DensityUtil() {
    }

    /**
     * Dip 2 px int.
     *
     * @param context the context
     * @param dpValue the dp value
     * @return the int
     */
    public static  int dip2Px(Context context,float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
