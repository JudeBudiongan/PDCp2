package com.mycompany.pdcproject1final;
/**
 *
 * @author jude
 */
/**
 * Represents the first player in the Snakes and Ladders game.
 */
public class Player1 extends Player {
    
    /**
     * Constructor for HumanPlayer class.
     * 
     * @param name The name of the human player
     */
    public Player1(String name) {
        super(name, true);
    }

    /**
     * Plays a turn for the human player.
     * 
     * @param gameBoard The game board object
     * @param diceRoll The result of the dice roll
     */
    @Override
    public void playTurn(GameBoard gameBoard, int diceRoll) {
        position += diceRoll;
        gameBoard.checkAndApplySnakeOrLadder(this); // Call the method from GameBoard
        
    }
    
   
}
