package com.e.blackjackapp;

import android.content.Context;
import android.content.res.Resources;

public class Game {
    Player player1;
    Dealer dealer;
    Deck deck;

    public Game(Resources res, Context context){
        deck = new Deck(res, context);
        player1 = new Player(deck);
        dealer = new Dealer(deck);
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
