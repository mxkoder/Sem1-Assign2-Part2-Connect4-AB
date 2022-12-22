package org.example.GameEnd;

import org.example.Player.Player;

public class GameWin {

    public static void printWinnerIfGameWon (Player player1, Player player2, int [][] gameGrid ) {

        // TODO change so that method returns the wining player object?

        int winningCounterInteger = winningCounterInteger(gameGrid);

        if (player1.getCounter().getCounterNumber() == winningCounterInteger) {
            System.out.printf("Congratulations!! Player %d you have won the game \n", player1.getCounter().getCounterNumber());

        } else if (player2.getCounter().getCounterNumber() == winningCounterInteger) {
            System.out.printf("Congratulations!! Player %d you have won the game \n", player2.getCounter().getCounterNumber());
        }
    }

    //TODO write tests for haveWinner
    /**
     * Method to determine whether if a connect 4 game has been won.
     * @param gameGrid 2D array representing a connect 4 game grid
     * @return boolean - returns true if the game has been won with a row, column or diagonal of 4 matching counters, and false if it has not been won.
     */
    public static boolean haveWinner (int [][] gameGrid) {

        boolean haveWinner = false;

        if(WinConditions.rowOf4Check(gameGrid) != -1 ||
            WinConditions.columnOf4Check(gameGrid) != -1 ||
            WinConditions.diagonalOf4Check(gameGrid) != -1
        ) {

            haveWinner = true;
        }

        return haveWinner;
    }


    //TODO comment & tests
    public static int winningCounterInteger ( int[][] gameGrid) {

        int winningCounterInteger = -1;

        if(WinConditions.rowOf4Check(gameGrid) != -1) {
            winningCounterInteger = WinConditions.rowOf4Check(gameGrid);
        }

        if(WinConditions.columnOf4Check(gameGrid) != -1) {
            winningCounterInteger = WinConditions.columnOf4Check(gameGrid);
        }

        if(WinConditions.diagonalOf4Check(gameGrid) != -1) {
            winningCounterInteger = WinConditions.diagonalOf4Check(gameGrid);
        }

        return winningCounterInteger;
    }
}
