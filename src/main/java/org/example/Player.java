package org.example;

public class Player {
    protected int playerNumber;
    protected String playerName;

    public Player(int playerNumber, String playerName) {
        this.playerName = playerName;
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
