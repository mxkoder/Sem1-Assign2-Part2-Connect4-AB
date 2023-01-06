package org.example.SpecialMoves;

import org.example.Player.Player;
import org.example.Turn.Turn;

public class SpecialMove {

    private int numberInGrid;
    private Character symbolInGrid;
    private int numberOfMoves;
    private String moveCommand;

    /**
     * Special Move object constructor used to initialise special move objects like Blitz and Time Bomb
     * @param numberInGrid - integer value representing the special move in the game grid
     * @param symbolInGrid - symbol printed out to the console representing the special move in the game grid
     * @param numberOfMoves - number of special moves a player has available
     * @param moveCommand - command a player needs to enter for the special move to be executed
     */
    public SpecialMove (int numberInGrid, Character symbolInGrid, int numberOfMoves, String moveCommand){

        this.numberInGrid = numberInGrid;
        this.symbolInGrid = symbolInGrid;
        this.numberOfMoves = numberOfMoves;
        this.moveCommand = moveCommand;
    }

    public int getNumberInGrid () {
        return numberInGrid;
    }

    public Character getSymbolInGrid () {
        return symbolInGrid;
    }

    public int getNumberOfMoves () {
        return numberOfMoves;
    }

    public String getMoveCommand () {
        return moveCommand;
    }

    /**
     * Method to reduce the number of special moves a player has by 1, and return a boolean false if the player does not have enough moves left
     * @return boolean - Returns true if there is at least 1 special move available to use, returns false otherwise
     */
    public boolean useUp1Move () {

        if(this.numberOfMoves < 1) {
            return false;
        }

        this.numberOfMoves -= 1;
        return true;
    }

    /**
     * Method to checks if a command matches a Special Move command, and then execute the special move
     * <p>Checks if a string command matches the command for Special Move objects like Time Bomb and Blitz.</p>
     * @param command - String command entered by the player to select a special move to execute
     * @param turnPlayer - Player object whose current turn it is with associated counter and special moves
     * @param otherPlayer -Player object with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     */
    public static void specialMoveCommand (String command, Player turnPlayer,Player otherPlayer, int[][] gameGrid) {

        if( command.equals(Blitz.blitzInitialise().getMoveCommand()) ) {
            Blitz.blitzMoveDialogue(gameGrid, turnPlayer, otherPlayer);

        } else if ( command.equals(TimeBomb.timeBombInitialise().getMoveCommand()) ) {
            TimeBomb.timeBombMoveDialogue(turnPlayer, otherPlayer, gameGrid);
        }

        else {
            Turn.errorMessageInvalidCommand();
            Turn.interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        }
    }
}


