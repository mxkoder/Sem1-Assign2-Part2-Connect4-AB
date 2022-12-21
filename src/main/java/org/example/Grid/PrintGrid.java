package org.example.Grid;

import org.example.Counters.Counter;

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

        switch (gridValue) {

            case -1:
                System.out.printf("-\t");
                break;
            case 1:
                Counter counter1X = Counter.counter1X();
                Character counter1XSymbol = counter1X.getCounterSymbol();
                System.out.printf("%c\t", counter1XSymbol);
                break;
            case 2:
                Counter counter2O = Counter.counter2O();
                Character counter2OSymbol = counter2O.getCounterSymbol();
                System.out.printf("%c\t", counter2OSymbol);
                break;
            case 10:
                System.out.printf("*\t");
                break;
            default:
                System.out.printf("error\t");
                break;
        }
    }

}
