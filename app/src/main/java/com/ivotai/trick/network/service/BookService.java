package com.ivotai.trick.network.service;

import com.ivotai.trick.model.BookResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {

    @SuppressWarnings("SameParameterValue")
    @GET("listDispatch")
    Call<BookResponse> listBook(@Query("action") String action, @Query("actionTag") String actionTag
            , @Query("actionId") String actionId, @Query("pagestamp") Integer pagestamp);

}