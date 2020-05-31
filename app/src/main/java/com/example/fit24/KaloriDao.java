package com.example.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KaloriDao {

    @Query("SELECT * FROM Kalori ORDER BY YemekAdi ASC")
    LiveData<List<Kalori>> getAlfabetikKalori();

    @Query("SELECT * FROM Kalori")
    LiveData<List<Kalori>> getKalori();

    @Query("SELECT * FROM Kalori WHERE YemekAdi LIKE '%' || :sorgu || '%'")
    List<Kalori> getSorgu(String sorgu);

    @Insert
    void save(Kalori kalori);
}
