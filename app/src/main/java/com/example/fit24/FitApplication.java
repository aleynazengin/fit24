package com.example.fit24;

import android.app.Application;

public class FitApplication extends Application {

    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = AppDatabase.getDatabase(this);

    }


    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
