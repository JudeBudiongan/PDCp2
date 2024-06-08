package com.mycompany.pdcproject1final;
/**
 *
 * @author jude
 */
/**
 * Represents an automated player in the Snakes and Ladders game.
 */
public class Player2 extends Player {
    
    public Player2(String name) {
        super(name, false);
    }

    @Override
    public void playTurn(GameBoard gameBoard, int diceRoll) {
        // Increment the player's position by the dice roll
        position += diceRoll;
        
        // Check and apply any snake or ladder effects on the player's position
        gameBoard.checkAndApplySnakeOrLadder(this); // Call the method from GameBoard
        
       
    }
}
