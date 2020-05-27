package com.example.fit24;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.room.Room;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class kalorilisteEkran extends Fragment {

    public kalorilisteEkran() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.fragment_kaloriliste_ekran, container, false);

        AppDatabase database = ((FitApplication)getActivity().getApplication()).getAppDatabase();

        final UserDao userDao = database.userDao();

        List<User> users = userDao.getUsers();
        for (int x = 0; x < users.size(); x++){
            Log.d("MainActivity", "ID: " + users.get(x).Id);
            Log.d("MainActivity", "USERNAME: " + users.get(x).Username);
            Log.d("MainActivity", "PASSWORD: " + users.get(x).Password);
            Log.d("MainActivity", "AGE: " + users.get(x).Age);
        }

     return view;
    }

}
