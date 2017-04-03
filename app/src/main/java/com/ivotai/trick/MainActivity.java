package com.ivotai.trick;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.hitomi.cslibrary.CrazyShadow;
import com.hitomi.cslibrary.base.CrazyShadowDirection;
import com.ivotai.trick.app.AppComponentProvider;
import com.ivotai.trick.base.BaseActivity;
import com.ivotai.trick.util.DensityUtil;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @Override
    protected boolean needTranslucentStatusBar() {
        return true;
    }

    @Override
    protected int layoutResID() {
        return R.layout.act_main;
    }

    @Override
    protected void injectDependency() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected void initViews() {
        addShadowForOperationBar();
    }

    @BindView(R.id.llBottomBar)
    LinearLayout llBottomBar;


    @Inject
    DensityUtil densityUtil;


    private void addShadowForOperationBar() {
        new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.TOP)
                .setShadowRadius(densityUtil.dip2Px(5))
                .setBaseShadowColor(ContextCompat.getColor(this, R.color.md_grey_200))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .action(llBottomBar);
    }


    @Override
    protected void initWorks() {
        Fragment fragment = new Fragment();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.replace(R.id.container, fragment);
        transition.commit();
    }
}
