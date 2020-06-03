package com.example.fit24;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM User WHERE Email LIKE '%' || :sorgu || '%'")
    List<User> getSorgum(String sorgu);

    @Insert
    void insertUsers(User user);

    @Update
    void updateUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();
}
