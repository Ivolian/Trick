package com.ivotai.trick.main.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ivotai.trick.R;
import com.ivotai.trick.app.helper.ToastHelper;
import com.ivotai.trick.base.BaseActivity;
import com.ivotai.trick.book.view.BookFragment;
import com.ivotai.trick.main.dagger.MainComponentProvider;
import com.ivotai.trick.main.presenter.MainPresenter;
import com.ivotai.trick.sideBar.view.SideBarFragment;
import com.ivotai.trick.util.DensityUtil;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

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
        MainComponentProvider.init(this);
        MainComponentProvider.provide().inject(this);
    }

    @Override
    protected void initViews() {
//        addShadowForOperationBar();
    }

    @BindView(R.id.llBottomTabs)
    LinearLayout llBottomTabs;


    @Inject
    DensityUtil densityUtil;

    @Inject
    ToastHelper toastHelper;

    @Inject
    MainPresenter mainPresenter;

    @Override
    public void onBackPressed() {
        mainPresenter.onBackPressed();
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


    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    public void showSideBar() {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @Override
    public void hideSideBar() {
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public boolean isSideBarOpen() {
        return drawerLayout.isDrawerOpen(Gravity.LEFT);
    }

    @BindView(R.id.tvBottomTab1)
    TextView tvBottomTab1;

    @BindView(R.id.ivBottomTab1)
    ImageView ivBottomTab1;

    @BindView(R.id.tvBottomTab2)
    TextView tvBottomTab2;

    @BindView(R.id.ivBottomTab2)
    ImageView ivBottomTab2;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindColor(R.color.md_grey_500)
    int md_grey_500;

    @Override
    public void selectBottomTab1() {
        ivBottomTab1.setBackgroundResource(R.drawable.maintab_bookstand_icon_hover);
        tvBottomTab1.setTextColor(colorPrimary);
        ivBottomTab2.setBackgroundResource(R.drawable.maintab_city_icon);
        tvBottomTab2.setTextColor(md_grey_500);
    }

    @Override
    public void selectBottomTab2() {
        ivBottomTab2.setBackgroundResource(R.drawable.maintab_city_icon_hover);
        tvBottomTab2.setTextColor(colorPrimary);
        ivBottomTab1.setBackgroundResource(R.drawable.maintab_bookstand_icon);
        tvBottomTab1.setTextColor(md_grey_500);
    }

}
