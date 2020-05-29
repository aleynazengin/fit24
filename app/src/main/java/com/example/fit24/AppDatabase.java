package com.example.fit24;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Kalori.class}, exportSchema = false, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract KaloriDao kaloriDao();

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
                        .build();
                }
            }
        }
        return INSTANCE;
    }
}
