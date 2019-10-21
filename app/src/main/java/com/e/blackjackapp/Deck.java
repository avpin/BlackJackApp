package com.e.blackjackapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.VectorDrawable;
import java.util.ArrayList;
import java.util.Random;

/**
 * A model of a deck of playing cards
 *
 * @author Alyssa Schilke
 * @version 1.0 09/29/2019
 */
public class Deck {

    Random rand;
    /**
     * Number of Cards in full deck
     */
    final int NUM_IN_DECK = 52;
    /**
     * Card ArrayList in the order of clubs, spades, hearts, diamonds; 2-10, Jack, Queen, King, Ace
     */
    ArrayList<Card> deck;
    /**
     * ArrayList of Card objects yet to be drawn, resets back to a shallow copy of deck on next draw when empty
     */
    ArrayList<Card> draw; //cards not yet drawn

    /**
     * Array used to initialize Card objects' names
     */
    String[] names = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    /**
     * Array used to initialize Card objects' point values
     */
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    /**
     * Array used to initialize Card objects' Drawable objects (svg images), context and res folder needed, so intialized in constructor
     */
    ArrayList<VectorDrawable> cardImgs = new ArrayList<VectorDrawable>();

    /**
     * Constructor,
     * initialises each card object in the deck array in club, spade, heart, diamond order with aces high.
     * <p>
     * initializes each drawable object, fills cardImgs;
     * this is done in constructor as context and res folder is needed in Drawable construtor
     *
     * @param res     - getResources(), needed to locate drawable files
     * @param context - needed for drawable constructor
     */
    public Deck(Resources res, Context context) {  //the drawable initalizer needs context and the res resource from Activity
        rand = new Random();
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

        for (int x = 0; x < NUM_IN_DECK; x++) {
            deck.add(new Card(cardImgs.get(x), values[x % 13], names[x % 13]));
        }
        draw = (ArrayList<Card>) deck.clone();
    }

    /**
     * returns Card at a given index in the deck ordered by clubs, spades, hearts, diamonds; with aces high
     *
     * @param index
     * @return Card from deck
     */
    public Card getCard(int index) {
        return deck.get(index);
    }


    /**
     * Draws (and removes) a random card from draw pile.
     * Resets draw pile when empty
     *
     * @return a random Card object
     */
    public Card drawCard() {
        if (draw.isEmpty()) {
            draw = (ArrayList<Card>) deck.clone();
            return drawCard();
        } else {
            return draw.remove(rand.nextInt(draw.size()));
        }
    }

    /**
     * returns the point value of given card object
     *
     * @param card the card object
     * @return interger point value of card
     */
    public int getCardValue(Card card) {
        return card.getValue(); // use accessors instead of directly accessing a private value
    }

    /**
     * returns the card's numerical value if index in the range of 0-52
     *
     * @param index of card in deck (clubs, spades, hearts, diamonds; aces high)
     * @return integer point value of card
     */
    public int getCardValue(int index) {
        return (index >= 52 && index < 0) ? -1 : deck.get(index).getValue();
    }

    /**
     * returns the card value give the text name
     *
     * @param name
     * @return the value, or -1 if name not found
     */
    public int getCardValue(String name) {
        for (int x = 0; x < names.length; x++) {
            if (names[x].equals(name)) {
                return values[x];
            }
        }
        return -1;
    }
}

