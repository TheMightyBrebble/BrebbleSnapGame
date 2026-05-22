package org.example;

import java.util.*;

public class CardGame {
    ArrayList<Card> deckOfCards = new ArrayList<Card>();
    ArrayList<Card> discardedCards = new ArrayList<Card>();
    public CardGame() {
        makeDeck();
        shuffleDeck();
    }

    private void makeDeck() {
        for (Suit suit : Suit.values()) {
            int value = 2;
            for(Symbol symbol : Symbol.values()) {
                deckOfCards.add(new Card(suit, symbol, value));
                value++;
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
        Card discarded = deckOfCards.removeFirst();
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
