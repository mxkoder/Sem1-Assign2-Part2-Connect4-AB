package org.example.SpecialMoves;

import org.example.Counters.Counter;
import org.example.GamePlay.GamePlay;
import org.example.Player.Player;
import org.example.Turn.TurnMechanism;
import org.example.UserInputs.ReadInput;

public class TimeBomb {

    public static SpecialMove timeBombInitialise () {
        SpecialMove timeBomb = new SpecialMove(10,'*',1,"T");
        return timeBomb;
    }

    //TODO test - on blitz move mechanics
    //TODO write java doc & tests

    //TODO - only do time bomb if have more than x spaces left in grid
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

    public static int timeBombDropCounter (Player turnPlayer, int[][] gameGrid) {
        int timeBombColumnIndex;
        int[] selectedColumn;
        int timeBombCounterNumber;
        boolean validColumn;

        do {

            timeBombColumnIndex = timeBombSelectColumnPrompt(gameGrid);

            selectedColumn = gameGrid[timeBombColumnIndex];
            timeBombCounterNumber = turnPlayer.getTimeBomb().getNumberInGrid();
            validColumn = TurnMechanism.takeTurnDropCounter(timeBombCounterNumber, selectedColumn);

            if (!validColumn) {
                System.out.printf("Please select another column to use your Time Bomb special move. \n");

            }

        } while (!validColumn) ;

        return timeBombColumnIndex;
    }

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

    public static void timeBombExplosion (int[][] gameGrid, int timeBombColumnIndex, int timeBombRowIndex) {

        int minColumnIndex;
        int maxColumnIndex;

        int minRowIndex;
        int maxRowIndex;

        // finding range of column values to clear
        if (timeBombColumnIndex == 0) {
            minColumnIndex = 0;
            maxColumnIndex = 1;

        } else if (timeBombColumnIndex == (gameGrid.length -1) ) {
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

            minRowIndex = timeBombRowIndex -1;
            maxRowIndex = timeBombRowIndex +1;
        }

        // looping through the game grid to clear the values when the time bomb 'explodes'
        for (int i = minColumnIndex; i <= maxColumnIndex ; i++) {

            for (int j = minRowIndex; j <= maxRowIndex; j++) {

                // Clearing the counters to the side and diagonal to the time bomb
                // special case for time bombs at the top of a game grid column
                if (j <= 2) {
                    gameGrid[i][j] = -1;

                } else if (j == 5) {
                    // 'dropping' the counters down by 2 spaces from above the area cleared by the time bomb to fill the gap
                    // special case for time bombs at the bottom of a game grid column
                    gameGrid[i][j] = gameGrid[i][j -2];
                    gameGrid[i][j -2] = -1;

                    gameGrid[i][j -1] = gameGrid[i][j -3];
                    gameGrid[i][j -3] = -1;

                } else {
                    // 'dropping' the counters down by 3 spaces from above the area cleared by the time bomb to fill the gap
                    gameGrid[i][j] = gameGrid[i][j -3];
                    gameGrid[i][j -3] = -1;
                }

            }
        }

    }
}
