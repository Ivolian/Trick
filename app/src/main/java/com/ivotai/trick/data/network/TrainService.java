package com.ivotai.trick.data.network;

import android.support.annotation.NonNull;

import com.ivotai.trick.data.model.Train;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrainService {

    @NonNull
    @GET("s")
    Call<Train> getTrain(@Query("key") String key, @Query("name") String name);

}
