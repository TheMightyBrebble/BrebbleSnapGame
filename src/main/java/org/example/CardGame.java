package org.example;

import java.util.*;

public class CardGame {
    //Two Array Lists. One for the deck of cards to be stored in, then a discard pile for the cards pulled
    ArrayList<Card> deckOfCards = new ArrayList<Card>();
    ArrayList<Card> discardedCards = new ArrayList<Card>();
    public CardGame() {
        //when the game is made, automatically form the deck and then shuffle it.
        makeDeck();
        shuffleDeck();
    }

    private void makeDeck() {
        // for each element in enum Suit, return all the values from each suit
        for (Suit suit : Suit.values()) {
            // for each element in enum Symbol, return all the values from each suit, including cardtype and numeric Value
            for(Symbol symbol : Symbol.values()) {
                deckOfCards.add(new Card(suit, symbol, symbol.numValue));
            }
        }
    }
    public void getDeck(){
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }


    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            throw new IllegalStateException("No cards remaining in this deck");
        }
        //Remove the first card from deckOfCards
        Card discarded = deckOfCards.removeFirst();
        //Put that card into the discard pile
        discardedCards.add(discarded);
        return discarded;
    }

    public void sortDeckInNumberOrder() {
        deckOfCards.sort(new sortDeckInNumberOrder());
        getDeck();
    }

    public void sortDeckIntoSuits() {
        deckOfCards.sort(new sortDeckIntoSuits());
        getDeck();
    }


    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

}
