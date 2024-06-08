package com.mycompany.pdcproject1final;

import javax.swing.*;
import java.awt.*;

public class GameInstructions extends JFrame {
    public GameInstructions() {
        setTitle("Instructions");
        setSize(450, 365);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setText("""
                                 ==========================================
                                 Welcome to Jude's Snakes and Ladders Game!
                                 ==========================================
                                 
                                 In this game, players take turns rolling a dice and moving themselves 
                                 along a numbered grid from 1-100. If a player lands on a position with 
                                 a ladder (GREEN LINE) on it, they climb to the top of the ladder, 
                                 advancing their position. If a player lands on a position with a snake 
                                 (RED LINE) on it, they slide to the bottom of the snake, hindering their 
                                 position. The first player to reach the final position on the
                                 grid, 100, wins the game!
                                 
                                 *Note that the Toggle Snakes/Ladders buttons only toggles their 
                                 visibility, not their functionality. a
                                 
                               
                                 JUDE BUDIONGAN - 22170014 - COMP603 PROJECT 2                           
                                 """);

        JScrollPane scrollPane = new JScrollPane(instructionsArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton startGameButton = new JButton("GO TO GAME"); // Change the button text
        startGameButton.addActionListener((var e) -> {
            dispose(); // Close the instructions window
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startGameButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the instructions window on the screen
        setVisible(true);
    }
}