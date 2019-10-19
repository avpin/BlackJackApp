package com.e.blackjackapp;


import java.util.ArrayList;


/**
 * A model of a BlackJack Player
 *
 * @author Aaron Pin
 * @author alyssaschilke
 * @version 1.0 09/29/2019
 */
/*package private*/ class Player {

    /**
     * The list holding the cards in the player's hand
     */
    private  ArrayList<Card> hand; // should not declare it public
    /**
     * the deck instance from the game the player is in
     */
    private Deck deck;
    /**
     * the point value of the cards in <CODE>hand</CODE>
     */
    /*package private*/ int points; // should not leave it

    /**
     * Player Object Constructor
     *
     * @param deck a deck of Cards
     */
    /*package private*/ Player(Deck deck) {
        hand = new ArrayList<Card>();
        this.deck = deck;
        hand.add(deck.drawCard()); //initially draw two cards to deck
        hand.add(deck.drawCard());
        tally();
    }

    /**
     * Retrieves an ArrayList of the Card in the Player's hand
     *
     * @return hand
     */
    /*package private*/ ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * updates current hand point value
     */
    /*package private*/ void tally() {
        points = 0;
        int aceCounter = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getName().equals("Ace")) {
                aceCounter++; //count aces in hand to determine whether ace should be 1 or 11
                points += hand.get(i).getCardValue();
            } else {
                points += hand.get(i).getCardValue();
            }
        }
        //determines ace value based on whether or not it causes points to be over 21
        while (aceCounter > 0 && points > 21) {
            points -= 10;
            aceCounter--;
        }

    }

    /**
     * Draws another card using the drawCard method
     *
     * @return boolean if sucessful
     */
    /*package private*/ boolean hit() {
        if (hand.size() < 5) {
            hand.add(deck.drawCard());
            tally();
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns true if Player has over 21 points, false otherwise
     *
     * @return true if busted
     */
    /*package private*/ boolean busted() {
        return points > 21;
    }

    /**
     * returns true if Player has 21 points
     * @return true if 21 points
     */
    protected boolean blackJack() {
        return points == 21;
    }
}
