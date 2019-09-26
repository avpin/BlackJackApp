package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CardTestActivity extends AppCompatActivity {
    Deck deck;
    ImageView imageView;
    Button button;
    TextView textView;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardtest);
        count = 0;

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        deck = new Deck(getResources(), this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count >= 52){
                    count = 0;
                };
                //Card c = deck.getCard(count++);
                Card c = deck.drawCard();
                textView.setText("Name: "+ c.name + " Value: " + c.value);
                imageView.setImageDrawable(c.face);
            }
        });

    }

}
