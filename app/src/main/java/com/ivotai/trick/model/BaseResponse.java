package com.ivotai.trick.model;

import java.util.List;

public abstract class BaseResponse<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
