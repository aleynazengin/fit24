package com.example.fit24;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KaloriDao {

    @Query("SELECT * FROM kalori")
    List<User> getKaloris();

    @Insert
    void save(Kalori kalori);
}
