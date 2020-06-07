package com.gelecek.fit24;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DiyetViewModel extends AndroidViewModel {
    private DiyetRepository mDRepository;

    private LiveData<List<Diyet>> mAllDiyet;

    public DiyetViewModel (Application application) {
        super(application);
        mDRepository = new DiyetRepository(application);
        mAllDiyet = mDRepository.getAllDiyet();
    }

    LiveData<List<Diyet>> getAllDiyet() { return mAllDiyet; }
}
