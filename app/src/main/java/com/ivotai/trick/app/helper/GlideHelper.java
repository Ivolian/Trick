package com.ivotai.trick.app.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

/**
 * The type Glide helper.
 * 加载图片
 */
public class GlideHelper {

    private Context context;

    /**
     * Instantiates a new Glide helper.
     *
     * @param context the context
     */
    @Inject
    public GlideHelper(Context context) {
        this.context = context;
    }

    /**
     * Load img.
     *
     * @param imgUrl the img url
     * @param target the target
     */
    public void loadImg(String imgUrl, ImageView target) {
        Glide.with(context).load(imgUrl).into(target);
    }

}
