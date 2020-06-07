package com.gelecek.fit24;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DiyetRepository {
    private DiyetDao mDiyetDao;
    private LiveData<List<Diyet>> mAllDiyet;


    DiyetRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mDiyetDao = db.diyetDao();
        mAllDiyet = mDiyetDao.getDiyetler();

    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Diyet>> getAllDiyet() {
        return mAllDiyet;
    }
}
