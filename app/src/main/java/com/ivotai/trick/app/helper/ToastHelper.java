package com.ivotai.trick.app.helper;

import android.content.Context;

import com.sdsmdg.tastytoast.TastyToast;

import javax.inject.Inject;

public class ToastHelper {

    private final Context context;

    @Inject
    ToastHelper(Context context) {
        this.context = context;
    }

    public void error(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.ERROR);
    }

}
