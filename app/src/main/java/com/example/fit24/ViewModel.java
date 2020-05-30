package com.example.fit24;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    UserRepository usersRepository;
    LiveData<List<User>> userList;

    public ViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UserRepository(application);
        userList = usersRepository.getUsers();

    }


    public LiveData<List<User>> getUsers(){
        return  usersRepository.getUsers();
    }

    public void insertUsers(User users){
        usersRepository.insertUsers(users);
    }


    public void updateUser(User users){
        usersRepository.updateUser(users);
    }



}
