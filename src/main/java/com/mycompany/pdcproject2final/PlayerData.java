package com.mycompany.pdcproject2final;

/**
 *
 * @author jude
 */
import java.io.FileWriter;
import java.io.IOException;
/**
 * Manages the game data, including player names and game outcomes.
 * I understand that this isn't a database component, but I could not get it
 * working in time so this is from my first project.
 */
public class PlayerData {
    private final String player1Name; 
    private final String player2Name; 
    private boolean player1Won; 
    private boolean player2Won; 

    /**
     * Constructs a PlayerData object with the names of two players.
     * 
     * @param player1Name The name of player 1.
     * @param player2Name The name of player 2.
     */
    public PlayerData(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Won = false;
        this.player2Won = false;
    }

    /**
     * Marks player 1 as the winner of the game.
     */
    public void player1Wins() {
        player1Won = true;
        player2Won = false;
    }

    /**
     * Marks player 2 as the winner of the game.
     */
    public void player2Wins() {
        player1Won = false;
        player2Won = true;
    }

    /**
     * Writes the game outcome for both players to a record file.
     */
    public void writeToRecordFile() {
        try {
            FileWriter writer = new FileWriter("game_record.txt", true);
            writer.write(player1Name + ": " + (player1Won ? "WON" : "LOST") + "\n");
            writer.write(player2Name + ": " + (player2Won ? "WON" : "LOST") + "\n");
            writer.write("-----\n");
            writer.close();
            System.out.println("Game record has been written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
