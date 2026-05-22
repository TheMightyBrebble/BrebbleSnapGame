package org.example;


public class Main {
    static void main() {
        Snap newGame = new Snap();
        newGame.playGame();
        Player p1 = new Player(1, "Ashlee");
        Player p2 = new Player(2, "Remi");
        newGame.play2PGame(p1, p2);
    }
}
