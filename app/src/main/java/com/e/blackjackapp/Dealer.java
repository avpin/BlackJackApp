package com.e.blackjackapp;

import android.widget.LinearLayout;

/**
 *
 */
public class Dealer extends Player {

    public Dealer(Deck d){
        super(d);
    }

    public int turn(Player p) {

        //
        if (comparePoints(p) == -1) {
            //dealer wins
            //while this.dealer;
            return -1;
        }
        if (comparePoints(p) == 1) {
            return 1;
        }
        //
        if (comparePoints(p) == 2) {
            p.hit();
            return turn(p);
        }
        return 0;
    }

}
