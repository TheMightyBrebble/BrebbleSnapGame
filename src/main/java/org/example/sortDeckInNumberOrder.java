package org.example;

import java.util.Comparator;

public class sortDeckInNumberOrder implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        return Integer.compare(c1.value, c2.value);
    }
}
