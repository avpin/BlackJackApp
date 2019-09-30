package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * A class representing a BlackJack Table.
 * This class sets up the game, takes input from user and notifies user when game is over.
 *
 * @author Aaron Pin
 * @author Alyssa Schilke
 * @version 1.0 09/29/2019
 */
public class GameActivity extends AppCompatActivity {
    /**
     * The layout of each player's hand
     */
    LinearLayout playerHand, dealerHand;
    /**
     * The player object for this Game
     */
    Player player;
    /**
     * The Dealer object for this Game
     */
    Dealer dealer;
    /**
     * The Deck object for this Game
     */
    Deck deck;
    /**
     * The buttons the user can interact with.
     */
    Button hitButton, stopButton, newGameButton;

    /**
     * An integer indicating if the Player has won
     */
    int PlayerWin;
    /**
     * Used for the Alert Dialog at the end of the game
     */
    AlertDialog.Builder builder;

    @Override
    /**
     * This method sets up the game, notifys the user with results when the game is over, and processes user input from the buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        builder = new AlertDialog.Builder(this);

        //Setting message and buttons on alert
        builder.setMessage("What do you want to do next?")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getApplicationContext(), GameActivity.class));
                    }
                })
                .setNegativeButton("Exit to Main Menu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });

        //initialize Objects
        deck = new Deck(getResources(), getApplicationContext());
        player = new Player(deck);
        dealer = new Dealer(deck);

        //display initial cards
        dealerHand = findViewById(R.id.llDealerHand);
        updateHandView(dealerHand, dealer);

        playerHand = findViewById(R.id.llPlayerHand);
        updateHandView(playerHand, player);


        //set up Buttons
        hitButton = findViewById(R.id.hitBtn_game);
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player.getHand().size() == 4) {
                    hitButton.setBackgroundResource(R.drawable.light_primary_button);
                } else if (player.getHand().size() >= 5) {
                    Toast.makeText(GameActivity.this, "Max Draw, please press Stop", Toast.LENGTH_SHORT).show();
                }
                if (player.getHand().size() < 5) {
                    player.hit();
                    updateHandView(playerHand, player);
                }
            }
        });
        stopButton = findViewById(R.id.stopBtn_game);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.busted()) {
                    PlayerWin = -1;
                } else {
                    PlayerWin = dealer.turn(player);
                    Log.d("myTag", "" + player.points + " " + dealer.points);
                    updateHandView(dealerHand, dealer);
                }

                //Creating dialog box
                AlertDialog alert = builder.create();
                String title = "";
                switch (PlayerWin) {
                    case -1:
                        title = "You Lose. The Dealer has won.";
                        break;
                    case 0:
                        title = "Tie!";
                        break;
                    case 1:
                        title = "You Win!";
                        break;
                }
                alert.setTitle(title);
                alert.show();
            }
        });
        newGameButton = findViewById(R.id.newGame_game);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameActivity.class));
            }
        });

    }

    /**
     * This method updates the giving linearLayout to show the images assocates with the cards in the given player's hand
     *
     * @param hand   - the Linear Layout to be changed
     * @param player - the player Object whose hand of cards the layout displays
     */
    private void updateHandView(LinearLayout hand, Player player) {
        hand.removeAllViews();
        for (Card c : player.getHand()) {
            int width = (getResources().getDisplayMetrics().widthPixels) / player.getHand().size();
            ImageView cardFace = new ImageView(getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, 400);
            cardFace.setLayoutParams(layoutParams);
            cardFace.setImageDrawable(c.getFace());
            hand.addView(cardFace);
        }
    }

}
