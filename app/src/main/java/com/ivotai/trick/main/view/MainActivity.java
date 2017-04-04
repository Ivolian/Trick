package com.ivotai.trick.main.view;

import android.os.Bundle;
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
import com.ivotai.trick.maybe.SimpleFragment;
import com.ivotai.trick.sideBar.view.SideBarFragment;
import com.ivotai.trick.util.DensityUtil;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

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
    protected void initViews(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            initFragments();
        }
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


    }


    private void initFragments() {
        Fragment fragment = new SideBarFragment();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.add(R.id.flSideBar, fragment, fragment.getClass().getCanonicalName());
        transition.commit();

        fragment = new BookFragment();
        transition = getSupportFragmentManager().beginTransaction();
        transition.add(R.id.flContent, fragment, fragment.getClass().getCanonicalName());
        transition.commit();

        fragment = new SimpleFragment();
        transition = getSupportFragmentManager().beginTransaction();
        transition.add(R.id.flContent, fragment, fragment.getClass().getCanonicalName());
        transition.hide(fragment);

        transition.commit();
    }

    @OnClick(R.id.llBottomTab1)
    public void bottomTabOnClick() {
        selectBottomTab1();
        showFragment1();
    }

    @OnClick(R.id.llBottomTab2)
    public void bottomTabOnClick2() {
        selectBottomTab2();
        showFragment2();
    }


    private void showFragment1() {
        String tag = BookFragment.class.getCanonicalName();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null && fragment.isHidden()) {
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.show(fragment);
            transition.commit();
        }

        tag = SimpleFragment.class.getCanonicalName();
        fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null && !fragment.isHidden()) {
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.hide(fragment);
            transition.commit();
        }
    }

    private void showFragment2() {
        String tag = SimpleFragment.class.getCanonicalName();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null && fragment.isHidden()) {
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.show(fragment);
            transition.commit();
        }

        tag = BookFragment.class.getCanonicalName();
        fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null && !fragment.isHidden()) {
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.hide(fragment);
            transition.commit();
        }
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
        ivBottomTab1.setImageResource(R.drawable.maintab_bookstand_icon_hover);
        tvBottomTab1.setTextColor(colorPrimary);
        ivBottomTab2.setImageResource(R.drawable.maintab_city_icon);
        tvBottomTab2.setTextColor(md_grey_500);
    }

    @Override
    public void selectBottomTab2() {
        ivBottomTab2.setImageResource(R.drawable.maintab_city_icon_hover);
        tvBottomTab2.setTextColor(colorPrimary);
        ivBottomTab1.setImageResource(R.drawable.maintab_bookstand_icon);
        tvBottomTab1.setTextColor(md_grey_500);
    }

}
