package com.ivotai.trick.data.sqlite;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.ivotai.trick.Provider;
import com.ivotai.trick.data.model.DaoMaster;
import com.ivotai.trick.data.model.DaoSession;

public final class DaoSessionProvider extends Provider<DaoSession> {


    private static final String DB_NAME = "trick-db";

    @Override
    public void init(Application application) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        setToProvide(daoSession);
    }


}
