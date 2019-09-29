package com.e.blackjackapp;

import android.graphics.drawable.VectorDrawable;

import androidx.annotation.NonNull;

public class Card {
    VectorDrawable face;
    int value;
    String name;

    public Card (VectorDrawable face, int value, String name) {
        this.face = face;
        this.value = value;
        this.name = name;
    }

    public VectorDrawable getFace() {
        return face;
    }

    public void setFace(VectorDrawable face) {
        this.face = face;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name + value;
    }
}
