package com.mycompany.pdcproject2final;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author jude
 */
/**
 * This class defines the instructions window for the Snakes and Ladders Game.
 * It extends JFrame and contains a JTextArea to display the game instructions.
 * A button is provided to close the instructions window and proceed to the game.
 */
public class GameInstructions extends JFrame {
    public GameInstructions() {
        setTitle("Instructions");
        setSize(450, 365);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setText(
                                    "==========================================\n" +
                                    "Welcome to Jude's Snakes and Ladders Game!\n" +
                                    "==========================================\n" +
                                    "\n" +
                                    "In this game, players take turns rolling a dice and moving themselves \n" +
                                    "along a numbered grid from 1-100. If a player lands on a position with \n" +
                                    "a ladder (GREEN LINE) on it, they climb to the top of the ladder, \n" +
                                    "advancing their position. If a player lands on a position with a snake \n" +
                                    "(RED LINE) on it, they slide to the bottom of the snake, hindering their \n" +
                                    "position. The first player to reach the final position on the \n" +
                                    "grid, 100, wins the game!\n" +
                                    "\n" +
                                    "*Note that the Toggle Snakes/Ladders buttons only toggles their \n" +
                                    "visibility, not their functionality.\n" +
                                    "\n" +
                                    "JUDE BUDIONGAN - 22170014 - COMP603 PROJECT 2\n"
);

        JScrollPane scrollPane = new JScrollPane(instructionsArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton startGameButton = new JButton("GO TO GAME"); 
        startGameButton.addActionListener((var e) -> {
            dispose(); // Close the instructions window
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startGameButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); 
        setVisible(true);
    }
}