package com.e.blackjackapp;

import android.graphics.drawable.VectorDrawable;

/**
 *
 *
 *
 */
public class Player {

    /**
     * Player Object Constructor
     */
    public Player (){
        String handStatus;
    }

    /**
     * Draws another card using the drawCard method
     * @return
     */
    public Card hit(Deck cardDeck){

        Card new_card =  cardDeck.drawCard();
        return new_card;
    }

    /**
     * Ends player turn
     */
    public void stop(){

    }


}
