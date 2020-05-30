package com.example.fit24;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private AppDatabase database;
    private LiveData<List<User>> usersList;
    public UserRepository(Application application) {
         database = AppDatabase.getDatabase(application);
        userDao = database.userDao();
        usersList = userDao.getUsers();
    }
    public LiveData<List<User>> getUsers(){
        return userDao.getUsers();
    }


    public void insertUsers(final User users){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.userDao().insertUsers(users);
                return null;
            }
        }.execute();
    }



    public void updateUser(final User users){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.userDao().updateUser(users);
                return null;
            }
        }.execute();
    }

}
