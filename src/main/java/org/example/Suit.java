package org.example;

public enum Suit {
    HEARTS(9829), DIAMONDS(9830), CLUBS(9827), SPADES(9824);

    final int htmlEntity;
    Suit(int htmlEntity) {
        this.htmlEntity = htmlEntity;
    }

}
