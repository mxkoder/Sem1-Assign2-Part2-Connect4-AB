package org.example.SpecialMoves;

import org.example.Counters.Counter;
import org.example.GamePlay.GamePlay;
import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.UserInputs.ReadInput;

public class Blitz {

    //TODO test - on blitz move mechanics
    //TODO write java doc
    public static void main(String[] args) {

        // Player and Counters setup
        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        SpecialMove blitz = Blitz.blitzInitialise();
        Player player1 = new Player( counter1X, blitz, 1);
        Player player2 = new Player(counter2O, blitz, 1);

        int[][] gameGrid = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 2, 2, 2, 2, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1}
        };

        PrintGrid.printGridWithColumnHeadings(gameGrid);

        blitzMoveDialogue(gameGrid, player1, player2);

        System.out.printf("after blitz \n");
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }

    public static void blitzMoveDialogue (int[][] gameGrid, Player turnPlayer, Player otherPlayer) {

        boolean haveMovesAvailable = turnPlayer.getBlitz().useUp1Move();

        if(haveMovesAvailable) {
            int selectedColumn = blitzSelectColumnPrompt(gameGrid);
            blitzMoveMechanics(gameGrid, selectedColumn, turnPlayer, otherPlayer);
            System.out.printf("You have successfully Blitzed column %d.\n", selectedColumn);

        } else {
            System.out.printf("You have already used up your Blitz move. Please take your turn with a valid column index or special move with moves remaining.\n");
            GamePlay.playGamePrintResult(turnPlayer, otherPlayer, gameGrid);

        }

    }

    //TODO combine with timebomb command?
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

    public static void blitzMoveMechanics ( int[][] gameGrid, int blitzColumnIndex, Player turnPlayer, Player otherPlayer) {

        int columnHeight = gameGrid[0].length;

        gameGrid[blitzColumnIndex] = BuildGrid.buildUnpopulatedStartColumn(columnHeight);

    }

    public static SpecialMove blitzInitialise () {
        SpecialMove blitz = new SpecialMove(-1,'-',1,"B");
        return blitz;
    }

}



