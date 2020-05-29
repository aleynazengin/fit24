package com.example.fit24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Database;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    EditText editText,editmail;
    Button buttonLogin;
    TextView textView;

    UserDao db;
    AppDatabase veritabani;

    public static FragmentManager fragmentManager;
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashekrani);
        fragmentManager= getSupportFragmentManager();
        appDatabase=Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"fit").allowMainThreadQueries().build();
        if(findViewById(R.id.fragment_container_view_tag)!=null){
            if (savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container_view_tag, new anaEkran()).commit();
        }


        AppDatabase database = ((FitApplication)getApplication()).getAppDatabase();

        editmail= findViewById(R.id.textMail);
        editText= findViewById(R.id.textSifre);
        buttonLogin=findViewById(R.id.buttonkayitol);
        textView=findViewById(R.id.textView);

        veritabani= Room.databaseBuilder(this,AppDatabase.class,"User")
                .allowMainThreadQueries()
                .build();
        veritabani= Room.databaseBuilder(this,AppDatabase.class,"User")
                .createFromAsset("database/fit.db")
                .build();
        db= veritabani.userDao();
        final UserDao userDao = database.userDao();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,kayitEkran.class);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail= editmail.getText().toString().trim();
                String sifre= editText.getText().toString().trim();

                User user =db.getUser(mail,sifre);

            }
        });


    }

}
