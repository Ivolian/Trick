package com.ivotai.trick.main.presenter;

import android.app.Activity;

import com.ivotai.trick.app.helper.ToastHelper;
import com.ivotai.trick.base.BasePresenter;
import com.ivotai.trick.main.dagger.MainScope;
import com.ivotai.trick.main.view.MainView;

import javax.inject.Inject;

@MainScope
public class MainPresenter implements BasePresenter {

    private final MainView mainView;

    @Inject
    ToastHelper toastHelper;

    @Inject
    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    private long exitTime = 0;


    public void onBackPressed() {
        if (mainView.isSideBarOpen()) {
            mainView.hideSideBar();
            return;
        }
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            toastHelper.error("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            Activity activity = (Activity) mainView;
            activity.finish();
        }
    }

}
