package com.ivotai.trick;

import android.app.Application;

import com.ivotai.trick.exception.NotInitException;

public abstract class Provider<T> {

    private T toProvide;

    protected final void setToProvide(T toProvide) {
        this.toProvide = toProvide;
    }

    public abstract void init(Application application);

//    [public/protected/private][static][abstract/final][native][synchronized]返回类型  方法名 ([参数表]) [throws 异常列表]{[方法体]}[;]
     public final T  provide() {
        if (toProvide == null) {
            throw new NotInitException();
        }
        return toProvide;
    }

}
