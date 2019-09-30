package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    LinearLayout playerHand, dealerHand;
    Player player;
    Dealer dealer;
    Button hitButton, stopButton, newGameButton;
    Deck deck;
    Boolean PlayerWin;

    AlertDialog.Builder builder;

    @Override
    /**
     * This method runs the game, notifying the user when the game is over, and setting the functionality of the buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        builder = new AlertDialog.Builder(this);

        //Setting message manually and performing action on button click
        builder.setMessage("What do you want to do next?")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getApplicationContext(),GameActivity.class));
                    }
                })
                .setNegativeButton("Exit to Main Menu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });

        deck = new Deck(getResources(), getApplicationContext());
        player = new Player(deck);
        dealer = new Dealer(deck);

        dealerHand = findViewById(R.id.llDealerHand);
        updateHandView(dealerHand,dealer);

        playerHand = findViewById(R.id.llPlayerHand);
        updateHandView(playerHand, player);


        hitButton = findViewById(R.id.hitBtn_game);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player.getHand().size() >= 5){
                    hitButton.setBackgroundResource(R.drawable.light_primary_button);
                    Toast.makeText(GameActivity.this, "Max Draw, please press Stop", Toast.LENGTH_SHORT).show();
                }
                else{
                    player.hit();
                    updateHandView(playerHand,player);
                }
            }
        });
        stopButton = findViewById(R.id.stopBtn_game);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player.busted())
                {
                    PlayerWin = false;
                }
                else {
                    PlayerWin = dealer.turn(player);
                    updateHandView(dealerHand, dealer);
                }
                //Creating dialog box
                AlertDialog alert = builder.create();
                alert.setTitle(PlayerWin ? "You Win!": "You Lose.");
                alert.show();
            }
        });

        newGameButton = findViewById(R.id.newGame_game);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GameActivity.class));
            }
        });


    }


    /**
     * This method updates the giving linearLayout to show the images assocates with the cards in the given player's hand
     * @param hand - the Linear Layout to be changed
     * @param player - the player Object whose hand of cards the layout displays
     */
    private void updateHandView(LinearLayout hand, Player player) {
        hand.removeAllViews();
        for (Card c: player.getHand()){
            int width = (getResources().getDisplayMetrics().widthPixels)/player.getHand().size();
            ImageView cardFace = new ImageView(getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, 400);
            cardFace.setLayoutParams(layoutParams);
            cardFace.setImageDrawable(c.getFace());
            hand.addView(cardFace);
        }
    }

}
