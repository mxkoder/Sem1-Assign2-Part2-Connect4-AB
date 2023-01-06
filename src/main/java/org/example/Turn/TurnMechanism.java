package org.example.Turn;

import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;

public class TurnMechanism {

    /**
     * Method to 'drop' a player's counter into the top empty space in a column pre-selected by the player
     * <P>The method will return false if the column is full and the play is not valid</P>
     * @param counterInteger - An integer value representing the player's counter.
     * @param column - A column in the connect 4 grid which has been selected by a player to drop their counter into
     * @return - boolean: true if the move was completed and valid, false if the column is full and the move is not valid.
     */
    public static boolean takeTurnDropCounter (int counterInteger, int[] column){

        if(getTopColumnEmptyIndex(column) == -1){
            System.out.printf("Error: This column is full. \n");
            return false;
        } else {
            column[getTopColumnEmptyIndex(column)] = counterInteger;
            return true;
        }
    }

    /**
     * Method to find the top empty cell in a column, returning the index of the empty cell.
     * <P>
     * Takes a 1D array representing a column in the connect 4 grid, this function looks through the column to find the first index
     * which can be written to. This returns -1 if the column is full.
     * @param column the 1D array to find the first empty index of.
     * @return the first empty index. This is -1 if the column is full.
     */
    public static int getTopColumnEmptyIndex(int[] column)
    {
        //Need account for the column being full, empty, or part filled
        // Will return the top index we can fill into
        for(int i = 0; i < column.length; i++)
        {
            if(column[i] != -1)
            {
                return i - 1; //Will give the top empty value of the column, or -1 if the column is full
            }
        }

        //If the method has not yet returned a value, all column values are -1
        // We will return the 'bottom' index at the base of the column on the connect 4 grid to write into.
        return column.length - 1;
    }
}
