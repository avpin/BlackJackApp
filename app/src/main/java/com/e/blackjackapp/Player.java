package com.e.blackjackapp;

import java.util.ArrayList;

/**
 *
 *
 *
 */
public class Player {

        private ArrayList<Card> hand;
        Deck deck;
        int points;
        /**
         * Player Object Constructor
         */
    public Player (Deck d){
        hand = new ArrayList<Card>();
        this.deck = d;
        generatehand();
        tally();
    }

    /**
     * Keeps track of current hand value
     *
     */
    private void tally() {
        for (int i = 0; i<hand.size(); i++){
            points += hand.get(i).getValue();
        }
    }

    /**
     *
     */
    private void generatehand() {
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
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
