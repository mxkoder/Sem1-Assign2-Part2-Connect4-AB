package org.example.SpecialMoves;

import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.UserInputs.ReadInput;

public class Blitz {

    //TODO test - on blitz move mechanics
    //TODO write java doc
    public static void main(String[] args) {

        int[][] gameGrid = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 2, 2, 2, 2, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1}
        };

        PrintGrid.printGridWithColumnHeadings(gameGrid);

        blitzMoveDialogue(gameGrid);

        System.out.printf("after blitz \n");
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }

    public static void blitzMoveDialogue (int[][] gameGrid) {

        int selectedColumn = blitzSelectColumnPrompt(gameGrid);
        blitzMoveMechanics(gameGrid, selectedColumn);
    }

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
    public static void blitzMoveMechanics ( int[][] gameGrid, int blitzColumnIndex) {

        int columnHeight = gameGrid[0].length;

        gameGrid[blitzColumnIndex] = BuildGrid.buildUnpopulatedStartColumn(columnHeight);

    }

    public static SpecialMove blitzInitialise () {
        SpecialMove blitz = new SpecialMove(-1,'-',1,"B");
        return blitz;
    }

}



