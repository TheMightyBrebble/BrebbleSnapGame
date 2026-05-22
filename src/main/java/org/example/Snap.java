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
            checkSpace();
        }
    }

    public void play2PGame(Player p1, Player p2) {
        String playerTurn = null;
        String nonTurnPlayer = null;
        while (true) {
            if(discardedCards.size() % 2 == 0) {
                playerTurn = p1.playerName;
                nonTurnPlayer = p2.playerName;
            }else{
                nonTurnPlayer  = p1.playerName;
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
                    int value = checkforSnap();
                    if(value == 0) {
                        System.out.printf("Snap! %s wins!", playerTurn);
                    } else{
                        System.out.printf("Snap! %s wins!", nonTurnPlayer);
                    }

                    break;
                }
            }
            checkSpace();
        }
    }


    public void checkSpace() {
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

    public int checkforSnap() {
        System.out.println("It's a pair! Say snap!");
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
            if (readString.equals("snap")) {
                //turn player has won
                return 0;
            }else{
                //turn player has lost
                return 1;
            }


    }
}
