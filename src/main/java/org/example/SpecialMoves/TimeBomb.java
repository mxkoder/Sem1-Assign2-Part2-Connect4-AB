package org.example.SpecialMoves;

import org.example.Counters.Counter;
import org.example.GamePlay.GamePlay;
import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.Turn.Turn;
import org.example.Turn.TurnMechanism;
import org.example.UserInputs.ReadInput;

public class TimeBomb {


    //TODO test - on blitz move mechanics
    //TODO write java doc
    public static void main(String[] args) {

        // Player and Counters setup
        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player1 = new Player( counter1X, blitz, timeBomb);
        Player player2 = new Player(counter2O, blitz, timeBomb);

        int[][] gameGrid = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 2, 2, 2, 2, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1}
        };

        PrintGrid.printGridWithColumnHeadings(gameGrid);

//        blitzMoveDialogue(gameGrid, player1, player2);

        System.out.printf("after time bomb \n");
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }

//    public static void blitzMoveDialogue (int[][] gameGrid, Player turnPlayer, Player otherPlayer) {
//
//        boolean haveMovesAvailable = turnPlayer.getBlitz().useUp1Move();
//
//        if(haveMovesAvailable) {
//            int selectedColumn = blitzSelectColumnPrompt(gameGrid);
//            blitzMoveMechanics(gameGrid, selectedColumn, turnPlayer, otherPlayer);
//            System.out.printf("You have successfully Blitzed column %d.\n", selectedColumn);
//
//        } else {
//            System.out.printf("You have already used up your Blitz move. Please take your turn with a valid column index or special move with moves remaining.\n");
//            GamePlay.playGamePrintResult(turnPlayer, otherPlayer, gameGrid);
//
//        }
//
//    }

    public static void timeBombExplosion (int[][] gameGrid, int timeBombColumnIndex, int timeBombRowIndex) {

        //TODO when call, get row index from getTopColumnEmptyIndex, called directly after time bomb counter was dropped

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

                //TODO - figure out if need to drop the counters above it after the 'explosion'

                //in loop
                // find diff 0 and row index j = diff
                // in loop: if diff >= 3, gameGrid[i][j] = gameGrid[i][j -3]

                gameGrid[i][j] = -1;

            }
        }

    }



    public static void timeBombDropCounter ( int[][] gameGrid, int timeBombColumnIndex, Player turnPlayer, Player otherPlayer) {

        boolean validColumn = false;

        int[] selectedColumn = gameGrid[timeBombColumnIndex];

        int timeBombCounterNumber = turnPlayer.getTimeBomb().getMoveNumberInGrid();

        validColumn = TurnMechanism.takeTurnDropCounter(timeBombCounterNumber, selectedColumn);

        if(!validColumn) {
            System.out.printf("This column is full. Please select another column to use your Time Bomb special move. \n");
            //TODO add method to take them to top of time bomb dialogue
        }

    }

    //TODO combine with blitz command?
    public static int timeBombSelectColumnPrompt (int[][] gameGrid){

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length - 1;

        System.out.printf("Time Bomb: please select Column:");
        int selectedColumn = ReadInput.readIntFromConsoleInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                "Please select a valid column for Time Bomb by entering an integer between");

        return selectedColumn;
    }


    public static SpecialMove timeBombInitialise () {
        SpecialMove timeBomb = new SpecialMove(10,'*',1,"T");
        return timeBomb;
    }

}
