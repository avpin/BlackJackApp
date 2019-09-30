package com.e.blackjackapp;

import android.widget.LinearLayout;

/**
 *
 */
public class Dealer extends Player {

    public Dealer(Deck d){
        super(d);
    }

    public boolean turn(Player p){

        //
        if(comparePoints(p) == 1){
            //dealer wins
            //while this.dealer;
            return true;
        }
        if(comparePoints(p) == -1){
            return false;
        }
        //
        if(comparePoints(p) == 2 ) {
            p.hit();
            return turn(p);
        }

    public boolean turn(Player p){

        return false;
    }

}
