package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras().getBoolean("hasWon") == true){
            setContentView(R.layout.activity_win);
        }
        else{
            setContentView(R.layout.activity_end);
        }
    }
}
