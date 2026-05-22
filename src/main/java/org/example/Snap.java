package org.example;

import java.util.*;
import java.io.*;

public class Snap extends CardGame{
    public void playGame() {
        boolean game = true;
        while (true) {
            //Puts card removed from top of the deck into a variable and then prints it
            Card dealtCard = this.dealCard();
            System.out.println("Dealt card: " + dealtCard);
            if (discardedCards.size() > 1) {
                System.out.println("Last card drawn: " + discardedCards.get(discardedCards.size() - 2));
                if (dealtCard.getSuit() == discardedCards.get(discardedCards.size() - 2).getSuit()) {
                    System.out.println("Snap!!!");
                    break;
                }
            }

            //Code for continuing the game after a card is revealed
            System.out.println("Press Enter Key to Continue.");
            Scanner scanner = new Scanner(System.in);
            String readString = scanner.nextLine();
            while (readString != null) {
                if (readString.isEmpty()) {
                    readString = null;
                }
                if (readString != null) {
                    System.out.println("Press ONLY the Enter Key to Continue.");
                    readString = scanner.nextLine();
                }
            }
        }
    }

}
