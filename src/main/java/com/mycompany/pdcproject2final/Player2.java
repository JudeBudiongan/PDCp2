package com.mycompany.pdcproject2final;
/**
 *
 * @author jude
 */
/**
 * Represents the second player in the Snakes and Ladders game. 
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
