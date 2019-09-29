package com.e.blackjackapp;

import android.graphics.drawable.VectorDrawable;

import java.util.ArrayList;

/**
 *
 *
 *
 */
public class Player {

    private ArrayList<Card> hand;

    /**
     * Player Object Constructor
     */
    public Player (ArrayList<Card> hand){
        this.hand = hand;
        String handStatus;
    }

    /**
     * Draws another card using the drawCard method
     * @return
     */
    public ArrayList<Card> hit(Deck cardDeck){

        Card new_card =  cardDeck.drawCard();
        hand.add(new_card);
        return hand;
    }

    /**
     * Ends player turn
     */
    public void stop(){

    }


}
