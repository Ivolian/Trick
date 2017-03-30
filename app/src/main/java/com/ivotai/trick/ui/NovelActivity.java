package com.ivotai.trick.ui;

import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.hitomi.cslibrary.CrazyShadow;
import com.hitomi.cslibrary.base.CrazyShadowDirection;
import com.ivotai.trick.R;
import com.ivotai.trick.ToolbarActivity;
import com.ivotai.trick.TrickApplication;
import com.ivotai.trick.network.BookServiceWrapper;
import com.ivotai.trick.util.DensityUtil;

import butterknife.BindView;
import retrofit2.Retrofit;

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
    protected final void init() {
        super.init();
        initOperationBar();
        getBooks();
    }

    /**
     * The Ll operation bar.
     */
    @BindView(R.id.llOperationBar)
    LinearLayout llOperationBar;

    private void initOperationBar() {
        addOperationBarShadow();
    }

    private void addOperationBarShadow() {
        new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.BOTTOM)
                .setShadowRadius(DensityUtil.dip2Px(this, 5))
                .setBaseShadowColor(ContextCompat.getColor(this, R.color.md_grey_200))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .action(llOperationBar);
    }


    private void getBooks(){
        Retrofit retrofit = TrickApplication.getRetrofitProvider().provide();
        BookServiceWrapper bookServiceWrapper = new BookServiceWrapper(retrofit);

    }



}
