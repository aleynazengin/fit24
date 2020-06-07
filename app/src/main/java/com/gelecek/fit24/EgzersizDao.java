package com.gelecek.fit24;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface EgzersizDao {
    @Query("SELECT * FROM Egzersiz")
    LiveData<List<Egzersiz>> getEgzersiz();

    @Query("SELECT * FROM Egzersiz EgzersizAdi")
    LiveData<List<Egzersiz>> getEgzersizAdi();

    @Query("SELECT * FROM Egzersiz EgzersizImage")
    LiveData<List<Egzersiz>> getEgzersizImage();

    @Query("SELECT * FROM Egzersiz EgzersizAciklama")
    LiveData<List<Egzersiz>> getEgzersizAciklama();


    @Insert
    void save(Egzersiz egzersiz);
}
