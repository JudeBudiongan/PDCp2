package com.mycompany.pdcproject1final;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Main class to launch the Snakes and Ladders game with GUI. 
 */
public class PDCProject1Final {

    public static void main(String[] args) {
        // Prompt user to enter player names
        final String[] playerNames = new String[2]; // Array to store player names

        while (true) {
            playerNames[0] = JOptionPane.showInputDialog(null, "Enter Player 1's (You) name:", "Player Setup", JOptionPane.QUESTION_MESSAGE);
            if (playerNames[0] == null) { // User pressed cancel or closed the dialog
                System.exit(0);
            }
            playerNames[1] = JOptionPane.showInputDialog(null, "Enter Player 2's (The CPU) name:", "Player Setup", JOptionPane.QUESTION_MESSAGE);
            if (playerNames[1] == null) { // User pressed cancel or closed the dialog
                System.exit(0);
            }

            if (playerNames[0].trim().isEmpty() || playerNames[1].trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Player names cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            if (playerNames[0].equalsIgnoreCase(playerNames[1])) {
                JOptionPane.showMessageDialog(null, "Player names must be unique. Please enter different names.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }

        // Display game instructions and setup the game GUI after the instructions window is closed
        SwingUtilities.invokeLater(() -> {
            GameInstructions instructions = new GameInstructions();
            instructions.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    // Initialize HumanPlayer and AutomatedPlayer objects
                    Player[] players = new Player[2];
                    players[0] = new Player1(playerNames[0]);
                    players[1] = new Player2(playerNames[1]);
                    // Create and display the GUI
                    new SnakesAndLaddersGUI(players, playerNames[0], playerNames[1]);
                   
                }
            });
        });
    }
}
