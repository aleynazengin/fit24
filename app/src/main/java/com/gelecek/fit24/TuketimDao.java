package com.gelecek.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TuketimDao {
    @Query("SELECT * FROM Tuketim")
    LiveData<List<Tuketim>> getTuketim();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTuketimler(Tuketim tuketim);
}
