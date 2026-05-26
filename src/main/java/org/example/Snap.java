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
        String playerTurn;
        String nonTurnPlayer;
        while (true) {
            //Rather than swapping the turn player between the variables, it checks whether the discard pile is even
            //or odd and assigns the turn to a p1 if even or p2 if odd
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
                    int value = checkForSnap();
                    //once the value has been given, 0 makes turn player win while a 1 makes the alternate
                    //player win
                    if(value == 0) {
                        System.out.printf("Snap! %s wins!", playerTurn);
                    } else{
                        System.out.printf("Oops, you missed your chance! %s wins!", nonTurnPlayer);
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

    public int checkForSnap() {
        System.out.println("It's a pair! Say snap!");
        Scanner scanner = new Scanner(System.in);
        boolean timerCheck = timeCounter();
        String readString = scanner.nextLine();
        //checks to see if the user has actually said Snap. If not, the other player wins
        if (timerCheck) {
            return 1;
        }
        if (readString.equals("snap") || readString.equals("Snap")) {
            //turn player has won
            return 0;
        }else{
            //turn player has lost
            return 1;
        }
    }


    public boolean timeCounter() {
        int timeCounter = 0;
        while (true) {
            System.out.printf("Time Remaining: %d\n", 2-timeCounter);
            if (timeCounter >= 2) {
                System.out.println("Time is up. Please press Enter Key to Continue.");
                return true;
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timeCounter++;
        }
    }
}
