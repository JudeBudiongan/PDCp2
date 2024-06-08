package com.mycompany.pdcproject1final;
/**
 *
 * @author jude
 */

/*
 * Represents a player in the Snakes and Ladders game.
 * Provides methods for accessing player information and executing game turns.
 */


public abstract class Player {
    protected String name;
    protected int position;
    private final boolean isHuman;
    
    public Player(String name, boolean isHuman) {
        this.name = name;
        this.position = 0;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
    
    public boolean isHuman() {
        return isHuman;
    }

    public abstract void playTurn(GameBoard gameBoard, int diceRoll);
}
