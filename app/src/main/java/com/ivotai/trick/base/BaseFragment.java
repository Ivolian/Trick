package com.ivotai.trick.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutResID(), container, false);
        ButterKnife.bind(this, view);
        injectDependency();
        initViews();
        initWorks();
        return view;
    }

    /**
     * Layout res id int.
     *
     * @return the int
     */
    protected abstract int layoutResID();


    /**
     * Inject dependency.
     */
    protected void injectDependency() {

    }

    /**
     * Init views.
     */
    protected void initViews() {

    }

    /**
     * Init works.
     */
    protected void initWorks() {

    }

}
