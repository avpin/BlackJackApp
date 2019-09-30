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
            if(hand.get(i).getName().equals("Ace")){
                aceCounter++;
            }
            else {
                points += hand.get(i).getValue();
            }
        }

        if(points>21){
            while(aceCounter>0){
                points -= 10;
                aceCounter--;
            }
        }
    }

    /**
     * Compares the hand status of whichever player called it to the other player
     * -1: lose, 0: tie, 1:win
     * @param p
     */
    public int comparePoints(Player p){
        int playerPoints = p.points;
        int otherPoints = this.points;
        //if both are 21, tied
        if(playerPoints ==21 && otherPoints==21){
            for (int i = 0; i<p.hand.size(); i++) { 
                //if player has has one of either jack, queen, king, combined with ace or a ten and an ace, they win
                if (((p.hand.get(i).getName().equals("Jack") || p.hand.get(i).getName().equals("Queen") ||
                    p.hand.get(i).getName().equals("King")) && (p.hand.get(i).getName().equals("Ace")))
                    || ((p.hand.get(i).getValue() == 10 && p.hand.get(i).getName().equals("Ace") ))){
                    return 1;
                }
                //if other player has one of either jack, queen, king, combined with ace, or a ten and an ace, they win
                if (((this.hand.get(i).getName().equals("Jack") || this.hand.get(i).getName().equals("Queen") ||
                    this.hand.get(i).getName().equals("King")) && (this.hand.get(i).getName().equals("Ace")))
                    || ((this.hand.get(i).getValue() == 10 && this.hand.get(i).getName().equals("Ace") ))){
                    return -1;
                }
                else{
                    return 0;
                }

            }
        }
        if(playerPoints > 21){
            return -1;
        }
        if(otherPoints > 21){
            return 1;
        }

        //if player is closer to 21, they win
        if ((21 - playerPoints) < (21 - otherPoints)) {

            return 1;
        }
        //if compared player is closer to 21, then player loses
        if ((21 - playerPoints) > (21 - otherPoints)) {

            return -1;
        }
        //if both hand sums are equally close to 21, they tie
        if ((21 - playerPoints) == (21 - otherPoints)) {
            return 0;
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

    public boolean busted() {
        return points > 21;
    }
}
