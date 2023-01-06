package org.example.Grid;

import org.example.Counters.Counter;
import org.example.SpecialMoves.TimeBomb;

public class PrintGrid {

    /**
     * Prints the connect4 grid to the console with column headings.
     * <P>How the counters are displayed is customisable in the displayCounterInGrid method</P>
     * @param gameGrid - 2D integer game grid to store positions of the counters
     */
    public static void printGridWithColumnHeadings (int [][] gameGrid){
        printGridColumnHeadings(gameGrid);
        printGrid(gameGrid);
    }

    /**
     * Prints the column headings of the Connect 4 game grid to the console
     * @param gameGrid - 2D integer game grid to store positions of the counters
     */
    public static void printGridColumnHeadings(int [][] gameGrid){

        for(int i = 0; i < gameGrid.length ; i++)
        {
            System.out.printf("%d\t", i);
        }

        System.out.print("\n");
    }

    /**
     * Prints the connect4 grid to the console without column headings.
     * <P>How the counters are displayed is customisable in the displayCounterInGrid method</P>
     * @param gameGrid - 2D integer game grid to store positions of the counters
     */
    public static void printGrid(int[][] gameGrid)
    {
        for(int i = 0; i < gameGrid[0].length; i++)
        {
            for(int j = 0; j< gameGrid.length; j++)
            {
                displayCounterInGrid(gameGrid[j][i]);
            }
            System.out.print("\n");
        }
    }

    /**
     * Method to map the values in the grid to the correct connect 4 counter symbols and print them to the console.
     * @param gridValue - the integer value at a game grid co-ordinate
     */
    public static void displayCounterInGrid ( int gridValue) {

        if (gridValue == -1) {
            System.out.printf("-\t");

        } else if (gridValue == Counter.counter1X().getCounterNumber() ) {
            System.out.printf("%c\t", Counter.counter1X().getCounterSymbol());

        } else if (gridValue == Counter.counter2O().getCounterNumber()) {
            System.out.printf("%c\t", Counter.counter2O().getCounterSymbol());

        } else if (gridValue == TimeBomb.timeBombInitialise().getNumberInGrid()) {
            System.out.printf("%s\t", TimeBomb.timeBombInitialise().getSymbolInGrid());

        } else {
            System.out.printf("error\t");
        }
    }
}
