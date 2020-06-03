package com.gelecek.fit24;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class KaloriViewModel extends AndroidViewModel {

    private KaloriRepository mRepository;

    private LiveData<List<Kalori>> mAllKalori;

    public KaloriViewModel (Application application) {
        super(application);
        mRepository = new KaloriRepository(application);
        mAllKalori = mRepository.getAllKalori();
    }

    LiveData<List<Kalori>> getAllKalori() { return mAllKalori; }

   // public void insert(Kalori kalori) { mRepository.insert(kalori); }
}
