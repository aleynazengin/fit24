package com.gelecek.fit24;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

class KaloriRepository {

    private KaloriDao mKaloriDao;
    private LiveData<List<Kalori>> mAllKalori;


    KaloriRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mKaloriDao = db.kaloriDao();
        mAllKalori = mKaloriDao.getAlfabetikKalori();

    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Kalori>> getAllKalori() {
        return mAllKalori;
    }

}
