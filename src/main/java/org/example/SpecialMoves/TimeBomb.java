package org.example.SpecialMoves;

import org.example.GamePlay.GamePlay;
import org.example.Player.Player;
import org.example.Turn.TurnMechanism;
import org.example.UserInputs.ReadInput;

public class TimeBomb {

    public static SpecialMove timeBombInitialise () {
        SpecialMove timeBomb = new SpecialMove(10,'*',1,"T");
        return timeBomb;
    }

    /**
     * Method to initiate the Time Bomb special move
     * <p>The time bomb will only be started if there are enough empty spaces left in the grid for the
     * time bomb to go off</p>
     * @param turnPlayer - Player object whose current turn it is with associated counter and special moves
     * @param otherPlayer -Player object with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     */
    public static void timeBombMoveDialogue (Player turnPlayer, Player otherPlayer, int[][] gameGrid) {

        int numberOfEmptySpacesInGrid = numberEmptySpacesInGrid(gameGrid);

        // Only let a player use a time bomb move if there are enough turns left for the time bomb to go off
        if (numberOfEmptySpacesInGrid >= 4) {

            boolean haveMovesAvailable = turnPlayer.getTimeBomb().useUp1Move();

            // Only let a player use their special move if they have enough special moves left
            if (haveMovesAvailable) {
                timeBombTurnSequence(turnPlayer, otherPlayer, gameGrid);

            } else {
                System.out.printf("You have already used up your Time Bomb move. Please take your turn with a valid column index or special move with moves remaining.\n\n");
                GamePlay.playGamePrintResult(turnPlayer, otherPlayer, gameGrid);

            }

        } else {
            System.out.printf("Your time bomb won't go off before the game grid is full, you're better off placing your counter.\n\n");
            GamePlay.playGamePrintResult(turnPlayer, otherPlayer, gameGrid);
        }
    }

    /**
     * Method to implement the time bomb special move
     * <p>The Time Bomb will explode after the other player has had two more turns, clearing all counters directly adjacent and diagonal to it</p>
     * @param turnPlayer - Player object whose current turn it is with associated counter and special moves
     * @param otherPlayer -Player object with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     */
    public static void timeBombTurnSequence (Player turnPlayer, Player otherPlayer, int[][] gameGrid) {

        // ----------Turn to drop the time bomb (continued) ------------------------
        int timeBombColumnIndex = timeBombDropCounter(turnPlayer, gameGrid);
        System.out.printf("You have successfully set a Time Bomb, it will go off after your opponent has taken two more turns. \n\n");

        // Get row index of time bomb counter placement
        int[] selectedColumn = gameGrid[timeBombColumnIndex];
        int timeBombRowIndex = TurnMechanism.getTopColumnEmptyIndex(selectedColumn) + 1;


        // ----------Other player, 1st turn during time bomb ------------------------
        GamePlay.singleTurnWithPrint(otherPlayer, turnPlayer, gameGrid);

        // ----------Turn player, 1st turn during time bomb ------------------------
        GamePlay.singleTurnWithPrint(turnPlayer, otherPlayer, gameGrid);

        // ----------Other player, 2nd turn during time bomb ------------------------
        GamePlay.singleTurnWithPrint(otherPlayer, turnPlayer, gameGrid);

        GamePlay.printPlayersAndGrid(turnPlayer, otherPlayer, gameGrid);

        // ----------Time Bomb explodes ------------------------
        timeBombExplosion(gameGrid, timeBombColumnIndex, timeBombRowIndex);
        System.out.printf("--------<<<<<<<<<< Time Bomb explosion!! >>>>>>>>>>-------\n");


        // Reset sequence of turns
        GamePlay.singleTurnWithPrint(turnPlayer, otherPlayer, gameGrid);
     }

    /**
     * Method to check the column selected by the player to drop a time counter into is not full
     * <p>The player is prompted to enter an integer for the game grid column they would like to drop their counter into</p>
     * <p>If they choose a full column they will be prompted to choose another column.</p>
     * @param turnPlayer - Player object whose current turn it is with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @return integer - Column index of the game grid column the time bomb counter was placed into
     */
    public static int timeBombDropCounter (Player turnPlayer, int[][] gameGrid) {
        int timeBombColumnIndex;
        int[] selectedColumn;
        int timeBombCounterNumber;
        boolean columnHasSpace;

        do {

            timeBombColumnIndex = timeBombSelectColumnPrompt(gameGrid);

            selectedColumn = gameGrid[timeBombColumnIndex];
            timeBombCounterNumber = turnPlayer.getTimeBomb().getNumberInGrid();
            columnHasSpace = TurnMechanism.takeTurnDropCounter(timeBombCounterNumber, selectedColumn);

            if (!columnHasSpace) {
                System.out.printf("Please select another column to use your Time Bomb special move. \n");

            }

        } while (!columnHasSpace) ;

        return timeBombColumnIndex;
    }

    /**
     * Method to prompt the player to choose a column to drop their time bomb counter into
     * <p>If they enter an out of bounds column index they will be prompted to re-enter</p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @return integer - Column index of the game grid column the time bomb counter was placed into
     */
    public static int timeBombSelectColumnPrompt (int[][] gameGrid){

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length - 1;

        System.out.printf("Time Bomb - please select Column:");
        int selectedColumn = ReadInput.readIntFromConsoleInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                "Please select a valid column for Time Bomb by entering an integer between");

        return selectedColumn;
    }

    /**
     * Method to check the number of empty spaces remaining in a Connect 4 game grid
     * <p>An empty space has a value of '-1' in the game grid integer array</p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @return integer - number of empty spaces left in a game grid
     */
    public static int numberEmptySpacesInGrid (int[][] gameGrid) {

        int noEmptyGridSpaces = 0;

        for(int i = 0; i < gameGrid[0].length; i++)
        {
            for(int j = 0; j< gameGrid.length; j++)
            {
                if(gameGrid[j][i] == -1) {

                    noEmptyGridSpaces += 1;
                }
            }

        }

        return noEmptyGridSpaces;
    }

    /**
     * Method to clear grid spaces directly adjacent and diagonal to the time bomb counter, and drop the counters above down to fill the space
     * <p>The method takes into account cases where the time bomb counter is at the edge or corner of the game grid</p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @param timeBombColumnIndex - Integer index of the game grid column the time bomb has been placed into
     * @param timeBombRowIndex - Integer index of the game grid row the time bomb has been placed into
     */
    public static void timeBombExplosion (int[][] gameGrid, int timeBombColumnIndex, int timeBombRowIndex) {

        int minColumnIndex;
        int maxColumnIndex;

        int minRowIndex;
        int maxRowIndex;

        // finding range of column values to clear
        if (timeBombColumnIndex == 0) {
            minColumnIndex = 0;
            maxColumnIndex = 1;

        } else if (timeBombColumnIndex == (gameGrid.length - 1)) {
            minColumnIndex = gameGrid.length - 2;
            maxColumnIndex = gameGrid.length - 1;

        } else {
            minColumnIndex = timeBombColumnIndex - 1;
            maxColumnIndex = timeBombColumnIndex + 1;
        }

        // finding range of row values to clear
        if (timeBombRowIndex == 0) {
            minRowIndex = 0;
            maxRowIndex = 1;

        } else if (timeBombRowIndex == gameGrid[0].length - 1) {
            minRowIndex = gameGrid[0].length - 2;
            maxRowIndex = gameGrid[0].length - 1;

        } else {

            minRowIndex = timeBombRowIndex - 1;
            maxRowIndex = timeBombRowIndex + 1;
        }

        //----------special case for time bombs at the bottom row of the game grid--------------------------------------------------
        // 'dropping' the counters down by 2 spaces from above the area cleared by the time bomb to fill the gap
        if (timeBombRowIndex == gameGrid[0].length - 1) {

            for (int i = minColumnIndex; i <= maxColumnIndex; i++) {
                for (int j = gameGrid[0].length - 1; j >= 0; j--) {

                    // Each row apart from the top 2 rows will 'drop' 2 rows down, with the bottom rows cleared by the time bomb explosion
                    if ( j >= 2) {
                        gameGrid[i][j] = gameGrid[i][j - 2];
                    // Top two rows will be empty with a '-1' value
                    } else {
                        gameGrid[i][j] = -1;
                    }
                }
            }


        } else {

            // looping through the game grid to clear the values when the time bomb 'explodes' and drop the counters above into the cleared space
            for (int i = minColumnIndex; i <= maxColumnIndex; i++) {

                for (int j = minRowIndex; j <= maxRowIndex; j++) {

                    //--------------------Special case for time bomb placement in the top of rows of the game grid--------------------------
                    if (j <= 2) {
                        gameGrid[i][j] = -1;

                    } else {
                        // ---------------------Standard case for time bomb placed in the middle rows of the game grid -----------------------
                        // 'dropping' the counters down by 3 spaces from above the area cleared by the time bomb to fill the gap
                        gameGrid[i][j] = gameGrid[i][j - 3];
                        gameGrid[i][j - 3] = -1;
                    }
                }
            }
        }

    }
}
