package org.example.Grid;

import org.example.Counters.Counter;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;

public class PrintGrid {

    /**
     * Prints the connect4 grid to the console with column headings.
     * <P>How the counters are displayed is customisable in the displauCounterInGrid method</P>
     * @param grid - 2D integer game grid to store positions of the counters
     */
    public static void printGridWithColumnHeadings (int [][] grid){
        printGridColumnHeadings(grid);
        printGrid(grid);
    }

    /**
     * Prints the column headings of the connect 4 game grid to the console
     * @param grid - 2D integer game grid to store positions of the counters
     */
    public static void printGridColumnHeadings(int [][] grid){

        for(int i = 0; i < grid.length ; i++)
        {
            System.out.printf("%d\t", i);
        }

        System.out.print("\n");

    }

    /**
     * Prints the connect4 grid to the console without column headings.
     * <P>How the counters are displayed is customisable in the displauCounterInGrid method</P>
     * @param grid - 2D integer game grid to store positions of the counters
     */
    public static void printGrid(int[][] grid)
    {
        for(int i = 0; i < grid[0].length; i++)
        {
            for(int j = 0; j< grid.length; j++)
            {
                displayCounterInGrid(grid[j][i]);
            }
            System.out.print("\n");
        }
    }

    /**
     * Method to map the values in the grid to the correct connect 4 counter symbols and print them to the console.
     * @param gridValue - the integer value at a gae grid co-ordinate
     */
    public static void displayCounterInGrid ( int gridValue) {

        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        if (gridValue == -1) {
            System.out.printf("-\t");

        } else if (gridValue == counter1X.getCounterNumber() ) {
            System.out.printf("%c\t", counter1X.getCounterSymbol());

        } else if (gridValue == counter2O.getCounterNumber()) {
            System.out.printf("%c\t", counter2O.getCounterSymbol());

        } else if (gridValue == timeBomb.getMoveNumberInGrid()) {
            System.out.printf("%s\t", timeBomb.getMoveSymbolInGrid());

        } else {
            System.out.printf("error\t");
        }
    }

}
