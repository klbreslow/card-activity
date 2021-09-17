package com.example.carddeck;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

public class Card {

    private Suit suit;
    private FaceValue value;

    public Card() {

    }

    public Card(Suit suit, FaceValue value) {
        this.suit = suit;
        this.value = value;
    }

    public int compareTo(Card that) {
        if (this.value.ordinal() > that.value.ordinal()) {
            return 1;
        } else if (this.value.ordinal() < that.value.ordinal()) {
            return -1;
        } else {
            if (this.suit.ordinal() > that.suit.ordinal()) {
                return 1;
            }
            else if (this.suit.ordinal() < that.suit.ordinal()) {
                return -1;
            }
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public FaceValue getValue() {
        return this.value;
    }

    public void setValue(FaceValue value){
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("suit=").append(suit);
        sb.append(", facevalue=").append(value);
        sb.append('}');
        return sb.toString();
    }
}