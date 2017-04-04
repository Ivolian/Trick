package com.ivotai.trick.main.view;

import com.ivotai.trick.base.BaseView;

public interface MainView extends BaseView {

    void showSideBar();

    void hideSideBar();

    boolean isSideBarOpen();

    void selectBottomTab1();

    void selectBottomTab2();

}
