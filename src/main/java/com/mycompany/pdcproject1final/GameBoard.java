package com.mycompany.pdcproject1final;
/**
 *
 * @author jude
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game board of Snakes and Ladders.
 * This class manages the positions of snakes and ladders on the board.
 *
 * @author jude
 */
public class GameBoard {

    
    public static final int BOARD_SIZE = 100;
    private final SnakesAndLaddersGUI gui; // Reference to the GUI
    
    public GameBoard(SnakesAndLaddersGUI gui) {
        this.gui = gui;
    }
    
    // Define lists to store snake and ladder starting and ending positions
    public static final List<Integer> snakeStarts = new ArrayList<>(List.of(12, 33, 45, 58, 60, 68, 71, 82, 89, 97));
    public static final List<Integer> snakeEnds = new ArrayList<>(List.of(2, 23, 15, 50, 5, 35, 40, 80, 77, 90));
    public static final List<Integer> ladderStarts = new ArrayList<>(List.of(1, 5, 10, 14, 29, 36, 49, 57, 84));
    public static final List<Integer> ladderEnds = new ArrayList<>(List.of(14, 27, 36, 48, 59, 70, 72, 91, 100));

    /**
     * Check if the player landed on a snake or ladder and apply the corresponding effect.
     *
     * @param player The player whose position needs to be checked.
     */
    public void checkAndApplySnakeOrLadder(Player player) {
        int currentPlayerPosition = player.getPosition();

        // Check for snakes
        for (int i = 0; i < snakeStarts.size(); i++) {
            if (currentPlayerPosition == snakeStarts.get(i)) {
                // Apply snake effect
                gui.appendToGameLog("Oh no! " + player.getName() + " landed on a snake. \nSliding down from position " 
                        +snakeStarts.get(i)+ " to " + snakeEnds.get(i) + ".");
                player.setPosition(snakeEnds.get(i)); // Set player's position to the end of the snake
                return; // Exit the method after applying the snake
            }
        }

        // Check for ladders
        for (int i = 0; i < ladderStarts.size(); i++) {
            if (currentPlayerPosition == ladderStarts.get(i)) {
               // Apply ladder effect
                gui.appendToGameLog("Yay! " + player.getName() + " landed on a ladder. \nClimbing up from position " 
                        +ladderStarts.get(i)+ " to "+ ladderEnds.get(i) + ".");
                player.setPosition(ladderEnds.get(i)); // Set player's position to the end of the ladder
                return; // Exit the method after applying the ladder
            }
        }
    }

   
}