package com.example.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KaloriDao {

    @Query("SELECT * FROM kalori ORDER BY YemekAdi ASC")
    LiveData<List<Kalori>> getAlfabetikKalori();

    @Insert
    void save(Kalori kalori);
}
