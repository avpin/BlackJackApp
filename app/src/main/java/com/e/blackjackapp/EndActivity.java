package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndActivity extends AppCompatActivity {
    Button newGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getIntent().getExtras().getBoolean("hasWon") == true){
            setContentView(R.layout.activity_win);
            newGame = findViewById(R.id.newGame1);
        }
        else{
            setContentView(R.layout.activity_end);
            newGame = findViewById(R.id.newGame2);
        }

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start new Game ()?
                // intent to gameActivity?

                startActivity(new Intent(getApplicationContext(), GameActivity.class));
            }
        });

    }
}
