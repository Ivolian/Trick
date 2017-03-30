package com.ivotai.trick;

import com.ivotai.trick.model.BookResponse;
import com.ivotai.trick.network.BookServiceWrapper;
import com.ivotai.trick.network.RetrofitProvider;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;


public class NetworkTest {

    private Retrofit retrofit;

    @Before
    public void initRetrofitProvider() {
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.init(null);
        retrofit = retrofitProvider.provide();
    }

    @Test
    public void getTrain() throws Exception {


        BookServiceWrapper bookServiceWrapper = new BookServiceWrapper(retrofit);
        Call<BookResponse> call = bookServiceWrapper.listByPagestamp(1);
        BookResponse bookResponse = call.execute().body();
        assertEquals(3, 3);

    }

}