package com.ivotai.trick.app.helper;

import android.content.Context;

import com.sdsmdg.tastytoast.TastyToast;

import javax.inject.Inject;

/**
 * The type Toast helper.
 */
public class ToastHelper {

    private final Context context;

    /**
     * Instantiates a new Toast helper.
     *
     * @param context the context
     */
    @Inject
    ToastHelper(Context context) {
        this.context = context;
    }

    /**
     * Error.
     *
     * @param msg the msg
     */
    public void error(String msg) {
        TastyToast.makeText(context, msg, TastyToast.LENGTH_SHORT, TastyToast.ERROR);
    }

}
