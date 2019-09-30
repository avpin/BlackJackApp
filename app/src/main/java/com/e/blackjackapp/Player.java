package com.e.blackjackapp;


import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    Deck deck;
    int points;

    /**
     * Player Object Constructor
     * @param deck
     */
    public Player (Deck deck){
        hand = new ArrayList<Card>();
        this.deck = deck;
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
        tally();
    }

    /**
     * Retrieves an ArrayList of the Card in the Player's hand
     * @return hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * updates current hand point value
     */
    private void tally() {
        int aceCounter = 0;
        for (int i = 0; i<hand.size(); i++){
            if(hand.get(i).getName().equals("Ace")){
                aceCounter++;
            }
            else {
                points += hand.get(i).getValue();
            }
        }

        while(aceCounter>0 && points > 21){
            points -= 10;
            aceCounter--;
        }

    }




    /**
     * Draws another card using the drawCard method
     * @return boolean if sucessful
     */
    public boolean hit(){
        if(hand.size() < 5) {
            hand.add(deck.drawCard());
            tally();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * returns true if Player has over 21 points, false otherwise
     * @return true if busted
     */
    public boolean busted() {
        return points > 21;
    }
}
