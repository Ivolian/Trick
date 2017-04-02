package com.ivotai.trick.book;

import com.ivotai.trick.model.BookResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface BookService {

    @SuppressWarnings("SameParameterValue")
    @GET("listDispatch")
    Observable<BookResponse> listBook(@Query("action") String action, @Query("actionTag") String actionTag
            , @Query("actionId") String actionId, @Query("pagestamp") Integer pagestamp);

}
