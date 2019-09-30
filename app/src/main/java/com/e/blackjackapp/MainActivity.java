package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * The class processing user input from the main menu, starts the game.
 *
 * @author Alyssa Schilke
 * @author Aaron Pin
 * @version 1.0 09/28/2019
 */
public class MainActivity extends AppCompatActivity {

    @Override
    /**
     * MainMenu onCreate, adds functionality to the button
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gameBtn = findViewById(R.id.main_btn1);
        gameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameActivity.class));
            }
        });


    }
}
