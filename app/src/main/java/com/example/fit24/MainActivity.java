package com.example.fit24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashekrani);
        getDatabase();

    }
    public void getDatabase(){
        AppDatabase database = ((FitApplication)getApplication()).getAppDatabase();

        final UserDao userDao = database.userDao();

    }
}
