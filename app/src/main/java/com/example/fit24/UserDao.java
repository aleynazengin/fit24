package com.example.fit24;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void save(User user);

    @Query("DELETE FROM user")
    void deleteAll();
}
