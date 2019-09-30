package com.e.blackjackapp;

import android.graphics.drawable.VectorDrawable;

public class Card {
    VectorDrawable face;
    int value;
    String name;

    /**
     * This is the constructor for the Card object
     * @param face - the VectorDrawable asset (image of card)
     * @param value - the points a card is worth (aces initially 11)
     * @param name - the string name of the card
     */
    public Card (VectorDrawable face, int value, String name) {
        this.face = face;
        this.value = value;
        this.name = name;
    }

    /**
     * retrieves the image resource of the card
     * @return face
     */
    public VectorDrawable getFace() {
        return face;
    }

    /**
     * Returns the card's point value
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Return the cards rank as a string
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    /**
     * represents the card as a string
     * @return a string representation of the card
     */
    public String toString() {
        return name + value;
    }
}
