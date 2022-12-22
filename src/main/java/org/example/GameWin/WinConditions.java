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
                {2, -1, -1, 1, -1, -1},
                {-1, 2, -1, -1, -1, -1},
                {-1, -1, 2, -1, -1, -1},
                {-1, -1, -1, 2, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };


        PrintGrid.printGridWithColumnHeadings(gameGrid);

//        int hasHorizontal = rowOf4Check(gameGrid);
//        System.out.printf("the counter no. with horizontal row of 4 is %d\n", hasHorizontal);


//        int hasColumn = columnOf4Check(gameGrid);
//        System.out.printf("the counter no. with column of 4 is %d\n", hasColumn);

        int hasDiagonal = diagonalOf4Check(gameGrid);
        System.out.printf("the counter no. with diagonal of 4 is %d\n", hasDiagonal);

    }

    /**
     * Method to check for a row of 4 identical counters in a game grid
     *
     * @param gameGrid - 2D integer array which represents a game grid in a Connect 4 game. The value '-1' n a cell denotes and empty cell.
     * @return - Integer - A positive integer with a value representing the counter that has a row of 4, or '-1' if there are no counters with a row of 4 in the grid.
     */
    public static int rowOf4Check(int[][] gameGrid) {

        int rowCounter = 1;

        // loop through the rows in the game grid
        for (int j = 0; j < gameGrid.length; j++) {

            // loop through the columns in the game grid
            for (int i = 0; i < gameGrid[0].length - 1; i++) {

                // for valid counter numbers, checks if two identical counters are next to each other
                if (gameGrid[i][j] == gameGrid[i + 1][j] && gameGrid[i][j] != -1) {

                    //totals up the number of identical adjacent counters in a row
                    rowCounter += 1;

                    if (rowCounter == 4) {
                        return gameGrid[i][j];
                    }

                } else {

                    rowCounter = 1;
                }
            }

            // resets the count for the number of matching adjacent counters if no row of 4 has been found
            rowCounter = 1;
        }

        return -1;
    }


    /**
     * Method to check for a column of 4 identical counters in a game grid
     *
     * @param gameGrid - 2D integer array which represents a game grid in a Connect 4 game. The value '-1' n a cell denotes and empty cell.
     * @return - Integer - A positive integer with a value representing the counter that has a column of 4, or '-1' if there are no counters with a diagonal of 4 in the grid.
     */
    public static int columnOf4Check (int[][] gameGrid) {

        int columnCounter = 1;

        // loop through the columns in the game grid
        for (int i = 0; i < gameGrid[0].length ; i++) {

            // loop through the columns in the game grid
            for (int j = 0; j < gameGrid.length - 1; j++) {

                // for valid counter numbers, checks if two identical counters are next to each other
                if (gameGrid[i][j] == gameGrid[i][j + 1] && gameGrid[i][j] != -1) {

                    //totals up the number of identical adjacent counters in a row
                    columnCounter += 1;

                    if (columnCounter == 4) {
                        return gameGrid[i][j];
                    }

                } else {

                    columnCounter = 1;
                }
            }
            // resets the count for the number of matching adjacent counters if no column of 4 has been found
            columnCounter = 1;
        }

        return -1;
    }


    /**
     * Method to check for a diagonal of 4 identical counters in a  6 x 6 game grid
     *
     * @param gameGrid - 2D 6 x 6 integer array which represents a game grid in a Connect 4 game. The value '-1' n a cell denotes and empty cell.
     * @return - Integer - A positive integer with a value representing the counter that has a diagonal of 4, or '-1' if there are no counters with a diagonal of 4 in the grid.
     */
    public static int diagonalOf4Check (int[][] gameGrid) {

        //-----------------Diagonal 4 in a row checks for diagonals starting in the bottom left corner of the game grid
        for (int i = 0; i <= 2 ; i++) {

            for (int j = 3; j < gameGrid.length; j++) {

                // for valid counter numbers, checks if four identical counters are in a diagonal row
                if (gameGrid[i][j] != -1) {

                    if (gameGrid[i][j] == gameGrid[i + 1][j - 1] &&
                            gameGrid[i + 1][j - 1] == gameGrid[i + 2][j - 2] &&
                            gameGrid[i + 2][j - 2] == gameGrid[i + 3][j - 3]
                    ) {
                        return gameGrid[i][j];
                    }
                }
            }
        }


        //-----------------Diagonal 4 in a row checks for diagonals starting in the bottom right corner of the game grid
        for (int i = 3; i < gameGrid[0].length ; i++) {

            for (int j = 3; j < gameGrid.length; j++) {

                // for valid counter numbers, checks if four identical counters are in a diagonal row
                if (gameGrid[i][j] != -1) {

                    if (gameGrid[i][j] == gameGrid[i - 1][j - 1] &&
                            gameGrid[i - 1][j - 1] == gameGrid[i - 2][j - 2] &&
                            gameGrid[i - 2][j - 2] == gameGrid[i - 3][j - 3]
                    ) {
                        return gameGrid[i][j];
                    }
                }
            }
        }

        return -1;
    }




}

