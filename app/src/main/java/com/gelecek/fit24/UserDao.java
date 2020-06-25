package com.gelecek.fit24;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM User WHERE Email LIKE '%' || :sorgu || '%'")
    List<User> getSorgum(String sorgu);

    @Query("SELECT * FROM User WHERE UserId= ( SELECT MAX(UserId) FROM User)")
    User getSonUser();

    @Query("SELECT * FROM User WHERE Email LIKE  :email   AND Password LIKE '%' || :sifre || '%'")
    List<User> getLoginSorgum(String email,String sifre);

    @Insert
    void insertUsers(User user);

    @Update
    void updateUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();
}
