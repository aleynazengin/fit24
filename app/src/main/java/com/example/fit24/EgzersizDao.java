package com.example.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface EgzersizDao {
    @Query("SELECT * FROM Egzersiz")
    LiveData<List<Egzersiz>> getEgzersiz();

    @Insert
    void save(Egzersiz egzersiz);
}
