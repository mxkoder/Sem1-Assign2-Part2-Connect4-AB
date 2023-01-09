package org.example.Turn;

import org.example.Player.Player;
import org.example.SpecialMoves.SpecialMove;
import org.example.UserInputs.ReadInput;

import java.util.*;

public class Turn {

    private static Scanner stdin = new Scanner(System.in);

    /**
     * Method to prompt a player for a command and interpret it
     * <p>Commands are either integer values to select a column to drop a counter, or letter commands for special moves</p>
     * <p>The method checks if the commands are valid, and will prompt the player to re-enter if not</p>
     * @param turnPlayer - Player object whose current turn it is with associated counter and special moves
     * @param otherPlayer -Player object with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     */
    public static void interpretPlayerCommand (Player turnPlayer, Player otherPlayer, int[][] gameGrid) {

        playerSelectColumnPrompt(turnPlayer);
        String playerInput = stdin.nextLine();

        if(playerInput.equals("")) {
            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        // Process for column index commands----------------------------------------------------------------
        } else if(playerInput.matches("^[0-9]*$")) {
            int selectedColumnIndex = Integer.parseInt(playerInput);

            boolean columnIndexInRange = checkColumnIndexRange(gameGrid, selectedColumnIndex);

            // Checking if integer input by player is a valid column index
            if (columnIndexInRange) {
                playerTakesNormalTurn(turnPlayer, otherPlayer, gameGrid, selectedColumnIndex);

            } else {
                errorMessageInvalidCommand();
                interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);
            }

        // Process for Special Move letter commands----------------------------------------------------------------
        } else if (playerInput.matches("^[a-zA-Z]*$")) {
            String moveCommand = playerInput.toUpperCase();
            SpecialMove.specialMoveCommand(moveCommand, turnPlayer, otherPlayer, gameGrid);

        } else {
            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        }
    }

    /**
     * Method to take a 'normal' Connect 4 turn where the player drops their counter into a column
     * <p>If the player chooses a full column, they will be asked to choose again</p>
     * @param turnPlayer - Player object whose current turn it is with associated counter and special moves
     * @param otherPlayer -Player object with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @param selectedColumnIndex - Integer index of the column selected in the game grid to drop a counter into
     */
    public static void playerTakesNormalTurn (Player turnPlayer, Player otherPlayer, int[][] gameGrid, int selectedColumnIndex){

        boolean columnHasSpace;
        int[] selectedColumn = gameGrid[selectedColumnIndex];
        int playerCounterNumber = turnPlayer.getCounter().getCounterNumber();

        columnHasSpace = TurnMechanism.takeTurnDropCounter(playerCounterNumber, selectedColumn);

        if(!columnHasSpace){
            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        }
    }

    /**
     * Method to prompt a player to select a column in the game grid to drop their counter into
     * @param player - Player object with associated counter and special moves
     */
    public static void playerSelectColumnPrompt (Player player) {

        int playerCounterNumber = player.getCounter().getCounterNumber();

        System.out.printf("Player %d Select Column:", playerCounterNumber);

    }

    /**
     * Method to check that the column index is not out of bounds for columns in the 2d game grid
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @param selectedColumnIndex - Integer index of the column selected in the game grid to drop a counter into
     * @return - boolean - true if the column index is within range for the game grid, false if the index is out of bounds
     */
    public static boolean checkColumnIndexRange (int[][] gameGrid, int selectedColumnIndex) {

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length - 1;

        boolean columnIndexValid = ReadInput.checkIntIsInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                selectedColumnIndex,
                "To drop a counter please select a valid column by entering an integer between");

        if(!columnIndexValid){
            return false;

        }
        return true;

    }

    public static void errorMessageInvalidCommand () {

        System.out.printf("Please enter a either a valid column index number or a single letter command for a special move. \n\n");
    }

}
