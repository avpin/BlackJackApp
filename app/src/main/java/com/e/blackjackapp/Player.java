package com.e.blackjackapp;

import android.graphics.drawable.VectorDrawable;

import java.util.ArrayList;

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
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
        tally();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Keeps track of current hand value
     *
     */
    private void tally() {
        int aceCounter =0;
        for (int i = 0; i<hand.size(); i++){
            if(hand.get(i).getName() == "Ace" ){
                aceCounter++;
            }
            else {
                points += hand.get(i).getValue();
            }
        }

        while(points>21){
                if(aceCounter>0){
                    points -= 10;
                    aceCounter--;
                }
            }
    }

    /**
     * -1: lose, 0: tie, 1:win, 2:player is closer, 3:dealer is closer
     * @param p
     */
    public int comparePoints(Player p){
        int playerPoints = p.points;
        int dealerPoints = this.points;
        if(playerPoints > 21){
            return -1;
        }
        if(dealerPoints > 21){
            return 1;
        }
        else {
            //if player is closer to 21
            if ((21 - playerPoints) > (21 - dealerPoints)) {

                return 2;
            }
            //if dealer is closer to 21
            if ((21 - playerPoints) < (21 - dealerPoints)) {

                return 3;
            }
            //if both hand sums are equally close to 21
            if ((21 - playerPoints) == (21 - dealerPoints)) {
                return 0;
            }
        }
        return 0;


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
     * Ends player turn
     */
    public void stop(){

    }


}
