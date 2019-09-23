package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Deck deck;
    ImageView imageView;
    Button button;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        deck = new Deck(getResources(), this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count >= 52){
                    count = 0;
                };

                imageView.setImageDrawable(deck.getCard(count++).face);
            }
        });

    }

}
