package com.mycompany.pdcproject1final;

import javax.swing.*;

public class GameController {
    private final Player[] players;
    private final GameBoard gameBoard;
    private final PlayerData playerData;
    private final int[] positions;
    private final SnakesAndLaddersGUI gui;
    private int currentPlayerIndex = 0;

    public GameController(Player[] players, String player1Name, String player2Name, SnakesAndLaddersGUI gui) {
        this.players = players;
        this.gameBoard = new GameBoard(gui);
        this.playerData = new PlayerData(player1Name, player2Name);
        this.positions = new int[players.length];
        this.gui = gui;
    }

    public void executePlayerTurn() throws InterruptedException {
        Player currentPlayer = players[currentPlayerIndex];

        if (currentPlayer.isHuman()) {
            int diceRoll = rollDice();
            gui.appendToGameLog("It is now " + currentPlayer.getName() + "'s turn.");
            gui.appendToGameLog(currentPlayer.getName() + " rolled a " + diceRoll + ".");
            currentPlayer.playTurn(gameBoard, diceRoll);
            gui.appendToGameLog(currentPlayer.getName() + " is now at position " + currentPlayer.getPosition() + ".");
            gui.appendToGameLog("----------");
        } else {
            
            gui.appendToGameLog("It is now " + currentPlayer.getName() + "'s turn.");
            int diceRoll = rollDice();
            gui.appendToGameLog(currentPlayer.getName() + " rolled a " + diceRoll + ".");
            currentPlayer.playTurn(gameBoard, diceRoll);
            gui.appendToGameLog(currentPlayer.getName() + " is now at position " + currentPlayer.getPosition() + ".");
            gui.appendToGameLog("----------");
        }

        updatePlayerPositions();

        if (checkGameOver(currentPlayer)) {
            playerData.writeToRecordFile();
            JOptionPane.showMessageDialog(gui, currentPlayer.getName() + " wins!!!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        gui.updateGameBoard();
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

    private void updatePlayerPositions() {
        for (int i = 0; i < players.length; i++) {
            positions[i] = players[i].getPosition();
        }
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
