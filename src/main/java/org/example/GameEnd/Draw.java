package org.example.GameEnd;

public class Draw {


    public static void printMessageIfGameDraw (int [][] gameGrid) {

        if(gameIsADraw(gameGrid)) {
            System.out.printf("The game is a draw! Neither player has won this time around. \n");
        }

    }


    //TODO javadoc comments and test
    public static boolean gameIsADraw (int [][] gameGrid) {

        if ( !GameWin.haveWinner(gameGrid) && gridIsFilled(gameGrid) ) {

            return true;
        }
        return false;
    }


    //TODO add Java doc method comment
    //TODO - check interaction with Time bomb - make sure do the check to see if the game is a draw AFTER the time bomb could have gone off following a player's 2nd turn
    public static boolean gridIsFilled (int[][] gameGrid) {

        boolean gridIsFilled = true;

        for(int i = 0; i < gameGrid[0].length; i++)
        {
            for(int j = 0; j< gameGrid.length; j++)
            {
                if(gameGrid[j][i] == -1) {

                    gridIsFilled = false;
                }
            }

        }

        return gridIsFilled;
    }
}
