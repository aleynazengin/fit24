package com.gelecek.fit24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  public int userId=0;

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

    public void SetLoginUserId(int Id) {
        this.userId= Id;
    }

    public int getLoginUserId() {
      return userId;

    }



}
