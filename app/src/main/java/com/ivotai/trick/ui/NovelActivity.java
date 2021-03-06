package com.ivotai.trick.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.hitomi.cslibrary.CrazyShadow;
import com.hitomi.cslibrary.base.CrazyShadowDirection;
import com.ivotai.trick.R;
import com.ivotai.trick.app.provider.AppComponentProvider;
import com.ivotai.trick.base.ToolbarActivity;
import com.ivotai.trick.util.DensityUtil;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * The type Novel activity.
 */
public class NovelActivity extends ToolbarActivity {

    @Override
    protected final int layoutResID() {
        return R.layout.act_novel;
    }

    @Override
    protected final String toolbarTitle() {
        return "玄幻";
    }

    @Override
    protected void injectDependency() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState
        );
        addShadowForOperationBar();
    }

    /**
     * The Ll operation bar.
     */
    @BindView(R.id.llOperationBar)
    LinearLayout llOperationBar;

    @Inject
    DensityUtil densityUtil;


    private void addShadowForOperationBar() {
        new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.BOTTOM)
                .setShadowRadius(densityUtil.dip2Px(5))
                .setBaseShadowColor(ContextCompat.getColor(this, R.color.md_grey_200))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .action(llOperationBar);
    }


}
