package com.ivotai.trick.network;

import com.ivotai.trick.model.BookResponse;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BookServiceWrapper {

//    action=categoryV3&actionTag=,-1,-1,-1,-1,6&actionId=20001&pagestamp=1

    private Retrofit retrofit;

    public BookServiceWrapper(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Call<BookResponse> listByPagestamp(Integer pagestamp) {
        BookService bookService = retrofit.create(BookService.class);
        return bookService.listBook("categoryV3", ",-1,-1,-1,-1,6", "20001", pagestamp);
    }


}
