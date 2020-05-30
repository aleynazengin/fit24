package com.example.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TuketimDao {
    @Query("SELECT * FROM Tuketim")
    LiveData<List<Tuketim>> getTuketim();

    @Insert
    void save(Tuketim tuketim);
}
