package com.ivotai.trick.ui;

import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.hitomi.cslibrary.CrazyShadow;
import com.hitomi.cslibrary.base.CrazyShadowDirection;
import com.ivotai.trick.R;

import butterknife.BindView;

public class NovelActivity extends ToolbarActivity {

    @Override
    protected final int layoutResID() {
        return R.layout.act_novel;
    }

    @Override
    protected final String getToolbarTitle() {
        return "玄幻";
    }

    @Override
    protected final void init() {
        super.init();
        initOperationBar();
    }

    @BindView(R.id.llOperationBar)
    LinearLayout llOperationBar;

    private void initOperationBar() {
        addShadowForOperationBar();
    }

    private void addShadowForOperationBar() {
        new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.BOTTOM)
                .setShadowRadius(dip2Px(5))
                .setBaseShadowColor(ContextCompat.getColor(this, R.color.md_grey_200))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .action(llOperationBar);
    }


    public final int dip2Px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
