package com.mycompany.pdcproject1final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakesAndLaddersGUI extends JFrame {
    private final GameBoardPanel gameBoardPanel;
    private final JPanel controlPanel;
    private final JButton rollDiceButton;
    private final JButton toggleSnakesButton;
    private final JButton toggleLaddersButton;
    private final JButton instructionsButton; 
    private final JTextArea gameLog;
    private final GameController gameController;

    public SnakesAndLaddersGUI(Player[] players, String player1Name, String player2Name) {
        setTitle("Snakes and Ladders");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameController = new GameController(players, player1Name, player2Name, this);

        gameBoardPanel = new GameBoardPanel(players);
        controlPanel = new JPanel();
        rollDiceButton = new JButton("ROLL DICE");
        toggleSnakesButton = new JButton("Toggle Snakes");
        toggleLaddersButton = new JButton("Toggle Ladders");
        instructionsButton = new JButton("Instructions"); // Initialize instructions button
        gameLog = new JTextArea(10, 30);
        gameLog.setEditable(false);

        // Action listener for instructions button
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameInstructions(); // Display game instructions when clicked
            }
        });

        rollDiceButton.addActionListener(e -> {
            try {
                gameController.executePlayerTurn();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        toggleSnakesButton.addActionListener(e -> gameBoardPanel.toggleSnakesVisibility());
        toggleLaddersButton.addActionListener(e -> gameBoardPanel.toggleLaddersVisibility());

        // Set preferred size for roll dice button to make it slightly bigger
        rollDiceButton.setPreferredSize(new Dimension(100, 100));

        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        controlPanel.add(rollDiceButton, gbc);

        gbc.gridy = 1;
        controlPanel.add(toggleSnakesButton, gbc);

        gbc.gridy = 2;
        controlPanel.add(toggleLaddersButton, gbc);

        gbc.gridy = 3;
        controlPanel.add(instructionsButton, gbc); 

        gbc.gridy = 4;
        gbc.weighty = 1;
        controlPanel.add(new JScrollPane(gameLog), gbc);

        add(gameBoardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateGameBoard() {
        gameBoardPanel.repaint();
    }

    public void appendToGameLog(String message) {
        gameLog.append(message + "\n");
    }
}
