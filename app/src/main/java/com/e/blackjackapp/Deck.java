package com.e.blackjackapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.*;

import java.util.ArrayList;

import androidx.appcompat.widget.VectorEnabledTintResources;

public class Deck {
    final int NUM_IN_DECK = 52;
    ArrayList<Card> deck;
    String[] names = {"Two","Three","Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    ArrayList<VectorDrawable> cardImgs = new ArrayList<VectorDrawable>();


    public Deck(Resources res, Context c) {  //the drawable initalizer needs context and the res resource from Activity
        deck = new ArrayList<Card>(52);
        //for some reason, extending an array of Drawables is not allowed. Pardon the block, but each card vector is in cardImgs
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c2, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c3, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c4, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c5, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c6, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c7, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c8, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c9, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c10, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.cj, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.cq, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.ck, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.ca, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s2, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s3, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s4, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s5, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s6, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s7, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s8, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s9, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s10, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sj, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sq, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sk, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sa, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h2, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h3, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h4, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h5, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h6, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h7, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h8, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h9, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h10, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.hj, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.hq, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.hk, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.ha, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d2, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d3, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d4, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d5, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d6, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d7, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d8, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d9, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d10, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.dj, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.dq, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.dk, c.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.da, c.getTheme()));

        generateDeck();
    }

    private void generateDeck() {
            for(int x = 0; x < NUM_IN_DECK; x++){
                deck.add(new Card(cardImgs.get(x),values[x%13],names[x%13]));
            }
    }

}
