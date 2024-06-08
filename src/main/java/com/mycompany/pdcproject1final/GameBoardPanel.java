package com.mycompany.pdcproject1final;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {
    private final Player[] players;
    private boolean snakesVisible = true;
    private boolean laddersVisible = true;

    public GameBoardPanel(Player[] players) {
        this.players = players;
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int tileSize = getWidth() / 10;
        drawBoard(g, tileSize);
        if (snakesVisible) drawSnakes(g, tileSize);
        if (laddersVisible) drawLadders(g, tileSize);
        drawPlayers(g, tileSize);
    }

    private void drawBoard(Graphics g, int tileSize) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int position = (9 - j) * 10 + (i + 1);
                if ((9 - j) % 2 == 1) {
                    position = (9 - j) * 10 + (10 - i);
                }
                g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
                g.drawString(String.valueOf(position), i * tileSize + tileSize / 2 - 5, j * tileSize + tileSize / 2 + 5);
            }
        }
    }

    private void drawSnakes(Graphics g, int tileSize) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
        g.setColor(Color.RED);
        for (int i = 0; i < GameBoard.snakeStarts.size(); i++) {
            drawLine(g, GameBoard.snakeStarts.get(i), GameBoard.snakeEnds.get(i), tileSize);
        }
    }

    private void drawLadders(Graphics g, int tileSize) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
        g.setColor(Color.GREEN);
        for (int i = 0; i < GameBoard.ladderStarts.size(); i++) {
            drawLine(g, GameBoard.ladderStarts.get(i), GameBoard.ladderEnds.get(i), tileSize);
        }
    }

    private void drawLine(Graphics g, int start, int end, int tileSize) {
        Point startPoint = getCoordinates(start, tileSize);
        Point endPoint = getCoordinates(end, tileSize);
        g.drawLine(startPoint.x + tileSize / 2, startPoint.y + tileSize / 2, endPoint.x + tileSize / 2, endPoint.y + tileSize / 2);
    }

    private void drawPlayers(Graphics g, int tileSize) {
        Color[] playerColors = {Color.BLUE, Color.ORANGE};
        for (int i = 0; i < players.length; i++) {
            int position = players[i].getPosition();
            Point coords = getCoordinates(position, tileSize);
            g.setColor(playerColors[i]);
            g.fillOval(coords.x + tileSize / 4, coords.y + tileSize / 4, tileSize / 2, tileSize / 2);
        }
    }

    private Point getCoordinates(int position, int tileSize) {
        int row = (position - 1) / 10;
        int col = (position - 1) % 10;
        if (row % 2 == 1) {
            col = 9 - col;
        }
        int x = col * tileSize;
        int y = (9 - row) * tileSize;
        return new Point(x, y);
    }
    
    public void toggleSnakesVisibility() {
        snakesVisible = !snakesVisible;
        repaint();
    }
    
    public void toggleLaddersVisibility() {
        laddersVisible = !laddersVisible;
        repaint();
    }
}
