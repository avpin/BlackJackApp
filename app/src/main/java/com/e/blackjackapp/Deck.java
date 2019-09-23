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


    public Deck(Resources res, Context context) {  //the drawable initalizer needs context and the res resource from Activity
        deck = new ArrayList<Card>(52);
        //for some reason, extending an array of Drawables is not allowed. Pardon the block, but each card vector is in cardImgs
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c2, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c3, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c4, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c5, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c6, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c7, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c8, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c9, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.c10, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.cj, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.cq, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.ck, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.ca, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s2, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s3, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s4, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s5, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s6, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s7, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s8, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s9, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.s10, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sj, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sq, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sk, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.sa, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h2, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h3, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h4, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h5, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h6, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h7, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h8, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h9, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.h10, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.hj, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.hq, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.hk, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.ha, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d2, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d3, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d4, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d5, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d6, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d7, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d8, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d9, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.d10, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.dj, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.dq, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.dk, context.getTheme()));
        cardImgs.add((VectorDrawable) res.getDrawable(R.drawable.da, context.getTheme()));

        generateDeck();
    }

    private void generateDeck() {
            for(int x = 0; x < NUM_IN_DECK; x++){
                deck.add(new Card(cardImgs.get(x),values[x%13],names[x%13]));
            }
    }
    public Card getCard(int index){
        return deck.get(index);
    }
}
