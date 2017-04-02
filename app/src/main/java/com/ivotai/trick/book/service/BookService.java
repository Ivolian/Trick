package com.ivotai.trick.book.service;

import com.ivotai.trick.model.BookResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * The interface Book service.
 */
public interface BookService {

    /**
     * List book observable.
     *
     * @param action    the action
     * @param actionTag the action tag
     * @param actionId  the action id
     * @param pagestamp the pagestamp
     * @return the observable
     */
    @SuppressWarnings("SameParameterValue")
    @GET("listDispatch")
    Observable<BookResponse> getBooks(@Query("action") String action, @Query("actionTag") String actionTag
            , @Query("actionId") String actionId, @Query("pagestamp") Integer pagestamp);

}
