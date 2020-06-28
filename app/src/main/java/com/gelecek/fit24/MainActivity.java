package com.gelecek.fit24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashekrani);
        hideActionBar();


    }




    public void showActionBar() {
        if (getSupportActionBar()!=null) {
            getSupportActionBar().show();
        }
    }
    public void hideActionBar() {
        if (getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
    }
}
