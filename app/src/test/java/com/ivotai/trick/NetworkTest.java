package com.ivotai.trick;

import com.ivotai.trick.config.GlobalSettings;
import com.ivotai.trick.data.model.Train;
import com.ivotai.trick.data.network.RetrofitProvider;
import com.ivotai.trick.data.network.TrainService;

import org.junit.Before;
import org.junit.Test;

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

        TrainService trainService = retrofit.create(TrainService.class);
        final String name = "G4";
        Train train = trainService
                .getTrain(GlobalSettings.appKey(), name)
                .execute()
                .body();

        assertEquals(train.getResult().getStation_list().size(), 3);

    }

}