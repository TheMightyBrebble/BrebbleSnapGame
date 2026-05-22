package org.example;

import java.util.*;
import java.io.*;

public class Snap extends CardGame{
    public void playGame() {
        while (true) {
            //Puts card removed from top of the deck into a variable and then prints it from a shuffled deck
            Card dealtCard = this.dealCard();
            System.out.println("Dealt card: " + dealtCard);
            //If statement checks the card against the last card put into the discard pile (done in dealCard method)
            //has to make sure the discard pile is greater than 1 otherwise it checks a card against itself
            if (discardedCards.size() > 1) {
                System.out.println("Last card drawn: " + discardedCards.get(discardedCards.size() - 2));
                if (dealtCard.getSuit() == discardedCards.get(discardedCards.size() - 2).getSuit()) {
                    System.out.println("Snap!!!");
                    break;
                }
            }

            //Code for continuing the game after a card is revealed, means that it doesn't automatically run
            // and end when a "Snap" is achieved. Allows for needing to type snap in future methods
            System.out.println("Press Enter Key to Continue.");
            Scanner scanner = new Scanner(System.in);
            String readString = scanner.nextLine();
            //System checks for an empty string, otherwise it resets.
            // this  is to solve any issues in the future involving picking the card
            while (readString != null) {
                if (readString.isEmpty()) {
                    break;
                }
                System.out.println("Press ONLY the Enter Key to Continue.");
                readString = scanner.nextLine();
            }
        }
    }

    public void play2PGame(Player p1, Player p2) {
        String playerTurn = null;
        while (true) {
            if(discardedCards.size() % 2 == 0) {
                playerTurn = p1.playerName;
            }else{
                playerTurn = p2.playerName;
            }
            System.out.println("Turn Player: " + playerTurn);
            //Puts card removed from top of the deck into a variable and then prints it from a shuffled deck
            Card dealtCard = this.dealCard();
            System.out.println("Dealt card: " + dealtCard);
            //If statement checks the card against the last card put into the discard pile (done in dealCard method)
            //has to make sure the discard pile is greater than 1 otherwise it checks a card against itself
            if (discardedCards.size() > 1) {
                System.out.println("Last card drawn: " + discardedCards.get(discardedCards.size() - 2));
                if (dealtCard.getSuit() == discardedCards.get(discardedCards.size() - 2).getSuit()) {
                    System.out.printf("Snap! %s wins!", playerTurn);
                    break;
                }
            }

            //Code for continuing the game after a card is revealed, means that it doesn't automatically run
            // and end when a "Snap" is achieved. Allows for needing to type snap in future methods
            System.out.println("Press Enter Key to Continue.");
            Scanner scanner = new Scanner(System.in);
            String readString = scanner.nextLine();
            //System checks for an empty string, otherwise it resets.
            // this  is to solve any issues in the future involving picking the card
            while (readString != null) {
                if (readString.isEmpty()) {
                    break;
                }
                System.out.println("Press ONLY the Enter Key to Continue.");
                readString = scanner.nextLine();
            }
        }
    }

}
