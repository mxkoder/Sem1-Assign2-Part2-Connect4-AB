package org.example.GameEnd;

import org.example.GamePlay.GamePlay;
import org.example.Player.Player;

public class GameWin {

    /**
     * Method to determine whether if a Connect 4 game has been won.
     * @param gameGrid - 2D integer array representing a Connect 4 game grid
     * @return boolean - returns true if the game has been won with a row, column or diagonal of 4 matching counters, and false if it has not been won.
     */
    public static boolean haveWinner (int [][] gameGrid) {

        boolean haveWinner = false;

        // Each win condition check returns the value of the winning counter if there's 4 in a row
        // A return of '-1' means no player has 4 in a row for that win condition
        if(WinConditions.rowOf4Check(gameGrid) != -1 ||
                WinConditions.columnOf4Check(gameGrid) != -1 ||
                WinConditions.diagonalOf4Check(gameGrid) != -1
        ) {

            haveWinner = true;
        }

        return haveWinner;
    }

    /**
     * Method to check if a player has won the game, and print a congratulations message if they have
     * <p> Uses winningCounterInteger to check if a player has won</p>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @param gameGrid - 2D integer array representing a Connect 4 game grid
     */
    public static void printWinnerIfGameWon (Player player1, Player player2, int [][] gameGrid ) {

        // winningCounterInteger will return the integer value of the counter that has won the game if there's a winner
        int winningCounterInteger = winningCounterInteger(gameGrid);

        if (player1.getCounter().getCounterNumber() == winningCounterInteger) {
            winningPlayerMessage(player1, player2, gameGrid);

        } else if (player2.getCounter().getCounterNumber() == winningCounterInteger) {
            winningPlayerMessage(player2, player1, gameGrid);
        }
    }

    /**
     * Method to print the game grid and then a message to the winning player
     * @param winningPlayer - Winning player object with associated counter and special moves
     * @param otherPlayer - Player object with associated counter and special moves
     * @param gameGrid - 2D integer array representing a Connect 4 game grid
     */
    public static void winningPlayerMessage (Player winningPlayer, Player otherPlayer, int[][] gameGrid) {

        GamePlay.printPlayersAndGrid(winningPlayer, otherPlayer, gameGrid);
        System.out.printf("Congratulations!! Player %d you have won the game. \n", winningPlayer.getCounter().getCounterNumber());
    }


    /**
     * Method to identify the counter that has won the game, or return a '-1' if there is no winner
     * @param gameGrid - 2D integer array representing a Connect 4 game grid
     * @return integer - Returns the integer value of the winning counter, or a '-1' if there is no winner
     */
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
