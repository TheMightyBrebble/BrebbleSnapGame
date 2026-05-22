package org.example;

public enum Suit {
    HEARTS(9825), DIAMONDS(9826), CLUBS(9827), SPADES(9828);

    final int htmlEntity;
    Suit(int htmlEntity) {
        this.htmlEntity = htmlEntity;
    }

}
