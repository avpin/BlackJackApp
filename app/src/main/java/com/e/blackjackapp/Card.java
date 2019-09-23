package com.e.blackjackapp;

import android.graphics.drawable.VectorDrawable;

public class Card {
    VectorDrawable face;
    int value;
    String name;

    public Card (VectorDrawable face, int value, String name) {
        this.face = face;
        this.value = value;
        this.name = name;
    }
}
