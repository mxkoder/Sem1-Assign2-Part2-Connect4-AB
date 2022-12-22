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
     * @return - valueOfWinningCounter - A positive integer with a value representing the counter that has a row of 4, or '-1' if there are no counters with a row of 4 in the grid.
     */
    public static int rowOf4Check(int[][] gameGrid) {

        int valueOfWinningCounter = -1;

        // loop through the rows in the game grid
        for (int j = 0; j < gameGrid.length; j++) {

            // loop through the columns on the left side of the game grid
            for (int i = 0; i <= 2; i++) {

                // for valid counter numbers, checks if four identical counters are next to each other in a row
                if (gameGrid[i][j] != -1  &&
                        gameGrid[i][j] == gameGrid[i + 1][j] &&
                        gameGrid[i + 1][j] == gameGrid[i + 2][j] &&
                        gameGrid[i + 2][j] == gameGrid[i + 3][j]
                ) {
                    valueOfWinningCounter = gameGrid[i][j];
                }
            }
        }

        return valueOfWinningCounter;
    }


    /**
     * Method to check for a column of 4 identical counters in a game grid
     *
     * @param gameGrid - 2D integer array which represents a game grid in a Connect 4 game. The value '-1' n a cell denotes and empty cell.
     * @return - valueOfWinningCounter - A positive integer with a value representing the counter that has a column of 4, or '-1' if there are no counters with a diagonal of 4 in the grid.
     */
    public static int columnOf4Check (int[][] gameGrid) {

        int valueOfWinningCounter = -1;

        // loop through the columns in the game grid
        for (int i = 0; i < gameGrid[0].length ; i++) {

            // loop through the rows in the top half of the game grid
            for (int j = 0; j <= 2; j++) {

                // for valid counter numbers, checks if four identical counters are next to each other in a column
                if (gameGrid[i][j] != -1 &&
                        gameGrid[i][j] == gameGrid[i][j + 1] &&
                        gameGrid[i][j + 1] == gameGrid[i][j + 2] &&
                        gameGrid[i][j + 2] == gameGrid[i][j + 3]
                ) {
                    valueOfWinningCounter = gameGrid[i][j];
                }
            }
        }

        return valueOfWinningCounter;
    }


    /**
     * Method to check for a diagonal of 4 identical counters in a  6 x 6 game grid
     *
     * @param gameGrid - 2D 6 x 6 integer array which represents a game grid in a Connect 4 game. The value '-1' n a cell denotes and empty cell.
     * @return - valueOfWinningCounter - A positive integer with a value representing the counter that has a diagonal of 4, or '-1' if there are no counters with a diagonal of 4 in the grid.
     */
    public static int diagonalOf4Check (int[][] gameGrid) {

        int valueOfWinningCounter = -1;

        for (int i = 0; i < gameGrid[0].length ; i++) {

            for (int j = 3; j < gameGrid.length; j++) {

                if (gameGrid[i][j] != -1) {

                    //Diagonal 4 in a row checks for diagonals starting in the bottom left corner of the game grid
                    if (i <= 2 &&
                            gameGrid[i][j] == gameGrid[i + 1][j - 1] &&
                            gameGrid[i + 1][j - 1] == gameGrid[i + 2][j - 2] &&
                            gameGrid[i + 2][j - 2] == gameGrid[i + 3][j - 3]
                    ) {
                        valueOfWinningCounter = gameGrid[i][j];

                    //Diagonal 4 in a row checks for diagonals starting in the bottom right corner of the game grid
                    } else if (i > 2 &&
                            gameGrid[i][j] == gameGrid[i - 1][j - 1] &&
                            gameGrid[i - 1][j - 1] == gameGrid[i - 2][j - 2] &&
                            gameGrid[i - 2][j - 2] == gameGrid[i - 3][j - 3]
                    ) {
                        valueOfWinningCounter = gameGrid[i][j];
                    }
                }
            }
        }

        return valueOfWinningCounter;
    }

}

