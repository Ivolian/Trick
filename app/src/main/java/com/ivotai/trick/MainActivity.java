package com.ivotai.trick;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.ivotai.trick.config.GlobalSettings;
import com.ivotai.trick.data.sqlite.DaoSessionProvider;
import com.ivotai.trick.data.model.Train;
import com.ivotai.trick.data.network.RetrofitProvider;
import com.ivotai.trick.data.network.TrainService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listNews();
    }


    private void listNews() {
        RetrofitProvider retrofitProvider = TrickApplication.getRetrofitProvider();
        TrainService service = retrofitProvider.provide().create(TrainService.class);
        final String name = "G4";
        Call<Train> call = service.getTrain(GlobalSettings.appKey(), name);
        call.enqueue(new Callback<Train>() {
            @Override
            public void onResponse(Call<Train> call, @NonNull Response<Train> response) {
                Train train = response.body();
                copeTrain(train);
            }

            @Override
            public void onFailure(Call<Train> call, Throwable t) {

            }
        });
    }


    private void copeTrain(@NonNull Train train) {
        DaoSessionProvider daoSessionProvider = TrickApplication.getDaoSessionProvider();
        daoSessionProvider.provide().getStationDao().insertInTx(train.getResult().getStation_list());
    }

}
