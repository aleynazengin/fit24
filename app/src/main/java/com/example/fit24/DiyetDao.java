package com.example.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DiyetDao {
    @Query("SELECT * FROM Diyet")
    LiveData<List<Diyet>> getDiyet();

    @Insert
    void save(Diyet diyet);
}
