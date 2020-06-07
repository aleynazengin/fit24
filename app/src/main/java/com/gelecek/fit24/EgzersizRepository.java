package com.gelecek.fit24;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class EgzersizRepository {
    private EgzersizDao mEgzersizDao;
    private LiveData<List<Egzersiz>> mAllEgzersiz;

    EgzersizRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mEgzersizDao = db.egzersizDao();
        mAllEgzersiz = mEgzersizDao.getEgzersiz();

    }

    LiveData<List<Egzersiz>> getAllEgzersiz() {
        return mAllEgzersiz;
    }

    public void insert(Egzersiz egzersiz) {
    }
}

