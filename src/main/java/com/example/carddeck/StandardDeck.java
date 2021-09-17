package com.example.carddeck;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck extends AbstractDeck {

    public StandardDeck(){
        this.cards = newDeck();
    }

    private List<Card> newDeck() {
        List<Card> newDeck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : StandardFaceValue.values()) {
                newDeck.add(new Card(suit, faceValue));
            }
        }

        return newDeck;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StandardDeck{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}