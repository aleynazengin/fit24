package com.example.fit24;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Kalori.class,Tuketim.class,Egzersiz.class,Diyet.class}, exportSchema = false, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract KaloriDao kaloriDao();
    public abstract TuketimDao tuketimDao();
    public abstract EgzersizDao egzersizDao();
    public abstract DiyetDao diyetDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
        Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "device.db")
                        .allowMainThreadQueries()
                        .createFromAsset("databases/fit.db")
                        .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
