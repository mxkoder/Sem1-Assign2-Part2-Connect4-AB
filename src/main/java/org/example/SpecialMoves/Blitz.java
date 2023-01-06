package org.example.SpecialMoves;

import org.example.GamePlay.GamePlay;
import org.example.Grid.BuildGrid;
import org.example.Player.Player;
import org.example.UserInputs.ReadInput;

public class Blitz {

    /**
     * Initialises a Blitz special move object with starting number of moves
     * @return - Blitz special move object
     */
    public static SpecialMove blitzInitialise () {
        SpecialMove blitz = new SpecialMove(-1,'-',1,"B");
        return blitz;
    }

    /**
     * Method to let the player make a Blitz with prompt asking for the column to Blitz
     * <p> The Blitz move will only be executed if the player has a Blitz move available </p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @param turnPlayer - Player object with associated counter and special moves
     * @param otherPlayer - Player object with associated counter and special moves
     */
    public static void blitzMoveDialogue (int[][] gameGrid, Player turnPlayer, Player otherPlayer) {

        boolean haveMovesAvailable = turnPlayer.getBlitz().useUp1Move();

        // Only let a player use their special move if they have enough special moves left
        if(haveMovesAvailable) {
            int selectedColumn = blitzSelectColumnPrompt(gameGrid);
            blitzMoveMechanics(gameGrid, selectedColumn);
            System.out.printf("You have successfully Blitzed column %d.\n", selectedColumn);

        } else {
            System.out.printf("You have already used up your Blitz move. Please take your turn with a valid column index or special move with moves remaining.\n\n");
            GamePlay.playGamePrintResult(turnPlayer, otherPlayer, gameGrid);

        }
    }

    /**
     * Method to prompt the player to select a column in the game grid to use their Blitz move on.
     * <p>Player can only choose a valid column index and will be prompted to re enter their value otherwise</p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @return integer - Column index to Blitz selected by player
     */
    public static int blitzSelectColumnPrompt (int[][] gameGrid){

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length - 1;

        System.out.printf("Blitz please select Column:");
        int selectedColumn = ReadInput.readIntFromConsoleInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                "Please select a valid column to blitz by entering an integer between");

        return selectedColumn;
    }

    /**
     * Method to execute the mechanics of a Blitz move and clear the selected column in a game grid
     * <p>All values in the column to Blitz will be replaced with '-1', which represents and empty grid cell</p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @param blitzColumnIndex - Column index to Blitz selected by player
     */
    public static void blitzMoveMechanics ( int[][] gameGrid, int blitzColumnIndex) {

        int columnHeight = gameGrid[0].length;

        gameGrid[blitzColumnIndex] = BuildGrid.buildUnpopulatedStartColumn(columnHeight);

    }
}



