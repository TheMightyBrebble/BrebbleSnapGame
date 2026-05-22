package org.example;

public class Card {
    protected Suit suit;
    protected Symbol symbol;
    protected int value;


    public Card(Suit suit, Symbol symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }
    public Card(Suit suit, Symbol symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return symbol.value + " OF " + Character.toString(suit.htmlEntity);
    }

}
