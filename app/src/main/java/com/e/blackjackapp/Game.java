package com.e.blackjackapp;

import android.content.Context;
import android.content.res.Resources;

public class Game {
    Player player1, dealer;
    Deck deck;

    public Game(Resources res, Context context){
        player1 = new Player();
        dealer = new Player();

        deck = new Deck(res, context);

    }



}
