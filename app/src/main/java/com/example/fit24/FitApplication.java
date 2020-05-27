package com.example.fit24;

import android.app.Application;

import androidx.room.Room;

public class FitApplication extends Application {

    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(
                this.getApplicationContext(),
                AppDatabase.class,
                "dbOndevice.db")
                .createFromAsset("fit24.db")
                .allowMainThreadQueries()
                .build();

    }


    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
