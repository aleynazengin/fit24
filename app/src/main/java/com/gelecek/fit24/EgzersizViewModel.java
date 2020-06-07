package com.gelecek.fit24;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EgzersizViewModel extends AndroidViewModel {
    private EgzersizRepository mERepository;

    private LiveData<List<Egzersiz>> mAllEgzersiz;

    public EgzersizViewModel (Application application) {
        super(application);
        mERepository = new EgzersizRepository(application);
        mAllEgzersiz = mERepository.getAllEgzersiz();
    }

    LiveData<List<Egzersiz>> getmAllEgzersiz() { return mAllEgzersiz; }
    //public void insert(Egzersiz egzersiz) { mERepository.insert(egzersiz); }
}
