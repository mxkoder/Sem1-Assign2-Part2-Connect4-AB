package org.example.GameEnd;

import org.example.GamePlay.GamePlay;
import org.example.Player.Player;

public class Draw {

    /**
     * Method to print a message if the result of the game is a draw
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     */
    public static void printMessageIfGameDraw (Player player1, Player player2, int [][] gameGrid) {

        if(gameIsADraw(gameGrid)) {
            GamePlay.printPlayersAndGrid(player1, player2, gameGrid);
            System.out.printf("The game is a draw! Neither player has won this time around. \n");
        }
    }

    /**
     * Method to determine if a game of connect4 is a draw
     * <p>Game will result in a draw if the grid is filled but there is no winner</p>
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @return boolean - True if the game is a draw, false otherwise
     */
    public static boolean gameIsADraw (int [][] gameGrid) {

        if ( !GameWin.haveWinner(gameGrid) && gridIsFilled(gameGrid) ) {

            return true;
        }
        return false;
    }


    /**
     * Method to check if the game grid is filled with counters or not
     * @param gameGrid - 2D integer array game grid to store positions of the Connect4 counters
     * @return boolean - true if the game grid is willed with counters, false if there is at least one empty  space (-1 value)
     */
    public static boolean gridIsFilled (int[][] gameGrid) {

        for(int i = 0; i < gameGrid[0].length; i++)
        {
            for(int j = 0; j< gameGrid.length; j++)
            {

                //Cells with a '-1' value are empty and do not contain a player counter
                if(gameGrid[j][i] == -1) {

                    return false;
                }
            }
        }

        return true;
    }
}
