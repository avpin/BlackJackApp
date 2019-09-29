package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GameActivity extends AppCompatActivity {
    LinearLayout playerHand, dealerHand;
    Player player;
    Dealer dealer;
    Button hitButton, stopButton, newGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Game game = new Game(getResources(), this);
        player = game.getPlayer1();
        dealer = game.getDealer();


        dealerHand = findViewById(R.id.llDealerHand);
        updateHandView(dealerHand,dealer);

        playerHand = findViewById(R.id.llPlayerHand);
        updateHandView(playerHand, player);

        hitButton = findViewById(R.id.hitBtn_game);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.hit()){
                }
                else {
                    hitButton.setBackgroundResource(R.drawable.light_primary_button);
                }
                updateHandView(playerHand,player);
            }
        });
        stopButton = findViewById(R.id.stopBtn_game);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dealer.turn();
            }
        });


    }

    private void updateHandView(LinearLayout hand, Player player) {
        hand.removeAllViews();
        for (Card c: player.getHand()){
            int width = (getResources().getDisplayMetrics().widthPixels)/player.getHand().size();
            ImageView cardFace = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, 300);
            cardFace.setLayoutParams(layoutParams);
            cardFace.setImageDrawable(c.getFace());
            hand.addView(cardFace);
        }
    }

}
