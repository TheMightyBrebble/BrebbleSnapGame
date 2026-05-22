package org.example;

import java.util.*;
import java.io.*;

public class Snap extends CardGame{
    public void playGame() {
        boolean game = true;
        while (true) {

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
