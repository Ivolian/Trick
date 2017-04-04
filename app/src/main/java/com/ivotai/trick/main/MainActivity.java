package com.ivotai.trick.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.ivotai.trick.R;
import com.ivotai.trick.app.helper.ToastHelper;
import com.ivotai.trick.app.provider.AppComponentProvider;
import com.ivotai.trick.base.BaseActivity;
import com.ivotai.trick.book.view.BookFragment;
import com.ivotai.trick.main.sidebar.view.SideBarFragment;
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
//        addShadowForOperationBar();
    }

    @BindView(R.id.llBottomBar)
    LinearLayout llBottomBar;


    @Inject
    DensityUtil denstyUtil;

    @Inject
    ToastHelper toastHelper;

    @Override
    public void onBackPressed() {
        toastHelper.error("无法签到！");

    }

    @Override
    protected void initWorks() {
        Fragment fragment = new BookFragment();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.replace(R.id.contentFrame, fragment);
        transition.commit();

        fragment = new SideBarFragment();
        transition = getSupportFragmentManager().beginTransaction();
        transition.add(R.id.flSideBar, fragment);
        transition.commit();


    }
}
