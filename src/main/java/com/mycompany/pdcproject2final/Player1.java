package com.mycompany.pdcproject2final;
/**
 *
 * @author jude
 */
/**
 * Represents the first player in the Snakes and Ladders game.
 */
public class Player1 extends Player {
    
    /**
     * Constructor for Player1 class.
     */
    public Player1(String name) {
        super(name, true);
    }

    /**
     * Plays a turn for Player1
     */
    @Override
    public void playTurn(GameBoard gameBoard, int diceRoll) {
        position += diceRoll;
        gameBoard.checkAndApplySnakeOrLadder(this); // Call the method from GameBoard
        
    }
    
   
}
