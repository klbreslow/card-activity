package com.example.carddeck;

public class DeckDriver {



    public static void main(String[] args) {

        Deck deck = new StandardDeck();

//        System.out.println(deck);
//
//        deck.shuffle();
//
//        System.out.println(deck);

        deck.newOrder(deck);

        System.out.println(deck);
    }
}
