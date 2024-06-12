package com.mycompany.pdcproject2final;

import javax.swing.*;
/**
 *
 * @author jude
 */
public class GameController {
    private final Player[] players;
    private final GameBoard gameBoard;
    private final PlayerData playerData;
    private final SnakesAndLaddersGUI gui;
    private int currentPlayerIndex = 0;
    private boolean firstTurn = true;

    public GameController(Player[] players, String player1Name, String player2Name, SnakesAndLaddersGUI gui) {
        this.players = players;
        this.gameBoard = new GameBoard(gui);
        this.playerData = new PlayerData(player1Name, player2Name);
        this.gui = gui;
    }

    public void startGame() {
        // Show the initial turn message
        gui.appendToGameLog("Welcome to Snakes and Ladders!\n---------");
        gui.appendToGameLog("It is now " + getCurrentPlayer().getName() + "'s (BLUE) turn.");
    }

    public void executePlayerTurn() throws InterruptedException {
            Player currentPlayer = players[currentPlayerIndex];
            
        if (!firstTurn) {
            if(currentPlayer == players[0]) {
            gui.appendToGameLog("It is now " + currentPlayer.getName() + "'s (BLUE) turn.");
            } else {
            gui.appendToGameLog("It is now " + currentPlayer.getName() + "'s (YELLOW) turn.");
            }
        } else {
            firstTurn = false;
        }

        int diceRoll = rollDice();
        gui.appendToGameLog(currentPlayer.getName() + " rolled a " + diceRoll + ".");

        // Capture old and new positions
        int oldPosition = currentPlayer.getPosition();
        int newPosition = oldPosition + diceRoll;

        // Cap the position to BOARD_SIZE if it exceeds the board size
        if (newPosition > GameBoard.BOARD_SIZE) {
            newPosition = GameBoard.BOARD_SIZE;
        }

        currentPlayer.setPosition(newPosition);
        gui.appendToGameLog(currentPlayer.getName() + " moved from position " + oldPosition + " to position " + newPosition + ".");

        // Apply any snake or ladder effect at the new position
        gameBoard.checkAndApplySnakeOrLadder(currentPlayer);

        // Log the final position after snake or ladder check
        gui.appendToGameLog(currentPlayer.getName() + " is now at position " + currentPlayer.getPosition() + ".");

        // Check if the player won after applying snake or ladder effects
        if (checkGameOver(currentPlayer)) {
            gui.updateGameBoard(); // Ensure the GUI reflects the final move
            playerData.writeToRecordFile();
            JOptionPane.showMessageDialog(gui, currentPlayer.getName() + " wins!!!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            return; // Exit the method to prevent further actions
        }
        
        gui.updateGameBoard(); // Update the board after all moves and effects

        // Prepare for the next turn
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        gui.appendToGameLog("\nTurn over. Roll dice to continue.\n----------");
    }

    private boolean checkGameOver(Player currentPlayer) {
        if (currentPlayer.getPosition() >= GameBoard.BOARD_SIZE) {
            if (currentPlayer == players[0]) {
                playerData.player1Wins();
            } else {
                playerData.player2Wins();
            }
            return true;
        }
        return false;
    }

    //Uses random int for dice roll
    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    // Method to get current player
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
}
