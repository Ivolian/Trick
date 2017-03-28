package com.ivotai.trick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ivotai.trick.data.TrainService;
import com.ivotai.trick.data.config.AppInfo;
import com.ivotai.trick.data.model.Train;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        listNews();
    }

    Retrofit retrofit;

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn/train/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private void listNews() {

        TrainService service = retrofit.create(TrainService.class);
        final String name = "G4";
        Call<Train> call = service.getTrain(AppInfo.appKey(), name);
        call.enqueue(new Callback<Train>() {
            @Override
            public void onResponse(Call<Train> call, Response<Train> response) {
                Train train = response.body();
                final String name = "G4";
            }

            @Override
            public void onFailure(Call<Train> call, Throwable t) {

            }
        });
    }

}
