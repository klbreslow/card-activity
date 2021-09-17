package com.example.carddeck;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class AbstractDeck implements Deck {

    protected List<Card> cards;

    public AbstractDeck(){

    }

    @Override
    public void cut(int index) {
        //Don't cut more cards than exist in the deck
        if (index < cards.size()) {
            //Takes top card and moves to bottom of deck...rinse and repeat
            for (int i = 0; i < index; i++) {
                cards.add(cards.remove(0));
            }
        }
    }

    @Override
    public Card deal() {
        return cards.remove(0);
    }

    public List<Card> getDeck(){
        return this.cards;
    }

    @Override
    public void newOrder(Deck deck) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuit().compareTo(cards.get(i + 1).getSuit()) == 1) {
                cards.add(i + 1,cards.remove(i));
                i = 0;
            }
        }
    }

    @Override
    public int search(Card card) {
        //Where in the list is the card
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) == card) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card turnOver() {
        return cards.get(0);
    }
}
