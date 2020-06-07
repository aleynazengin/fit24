package com.gelecek.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DiyetDao {
    @Query("SELECT * FROM Diyet")
    LiveData<List<Diyet>> getDiyetler();

    @Insert
    void save(Diyet diyet);
}
