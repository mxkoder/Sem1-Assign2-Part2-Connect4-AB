package org.example.GameWin;

import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;

public class WinConditions {

    public static void main(String[] args) {

//        int[][] gameGrid = BuildGrid.buildInitialGrid(6,6);
//
//        gameGrid[0][5] = 1;
//        gameGrid[1][5] = 1;
//        gameGrid[2][5] = 1;
//        gameGrid[3][5] = -1;
//        gameGrid[4][5] = -1;

        int[][] gameGrid = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, 1, -1, -1}
        };


        PrintGrid.printGridWithColumnHeadings(gameGrid);

        int hasHorizontal = horizontalRowOf4Check(gameGrid);

        System.out.printf("the counter no. with horizontal row of 4 is %d\n", hasHorizontal);


    }

    /**
     * Method to check for a row of 4 identical counters in a game grid
     * @param gameGrid - 2D integer array which represents a game grid in a Connect 4 game. The value '-1' n a cell denotes and empty cell.
     * @return - Integer - A positive integer with a value representing the counter that has a row of 4, or '-1' if there are no counters with a row of 4 in the grid.
     */
    public static int horizontalRowOf4Check (int[][] gameGrid) {

        int rowCounter = 1;

        // loop through the rows in the game grid
        for (int j = 0; j < gameGrid.length; j++) {

            // loop through the columns in the game grid
             for (int i = 0; i < gameGrid[0].length -1; i++) {

                 // for valid counter numbers, checks is two identical counters are next to each other
                if (gameGrid[i][j] == gameGrid[i + 1][j] && gameGrid[i][j] != -1) {

                    //totals up the number of identical adjacent counters in a row
                    rowCounter += 1;

                    if (rowCounter == 4) {
                        return gameGrid[i][j];
                    }
                }
            }

             // resets the number of adjacent counters after the check of a row is complete without finding a row of 4 identical counters
            rowCounter = 1;
        }

        return -1;

    }

}
