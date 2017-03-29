package com.ivotai.trick;

import android.content.Intent;

import com.ivotai.trick.ui.NovelActivity;

import butterknife.OnClick;

public class MainActivity extends ButterKnifeActivity {

    @Override
    protected final int layoutResID() {
        return R.layout.act_main;
    }

    @OnClick(R2.id.readNovel)
    public final void readNovel() {
        Intent intent = new Intent(this, NovelActivity.class);
        startActivity(intent);
    }


//
//    private void listNews() {
//        RetrofitProvider retrofitProvider = TrickApplication.getRetrofitProvider();
//        TrainService service = retrofitProvider.provide().create(TrainService.class);
//        final String name = "G4";
//        Call<Train> call = service.getTrain(GlobalSettings.appKey(), name);
//        call.enqueue(new Callback<Train>() {
//            @Override
//            public void onResponse(Call<Train> call, @NonNull Response<Train> response) {
//                Train train = response.body();
//                copeTrain(train);
//            }
//
//            @Override
//            public void onFailure(Call<Train> call, Throwable t) {
//
//            }
//        });
//    }
//
//
//    private void copeTrain(@NonNull Train train) {
////        DaoSessionProvider daoSessionProvider = TrickApplication.getDaoSessionProvider();
////        daoSessionProvider.provide().getStationDao().insertInTx(train.getResult().getStation_list());
//    }

}
