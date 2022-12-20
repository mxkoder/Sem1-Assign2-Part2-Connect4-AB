package org.example.Game;

import java.lang.ref.PhantomReference;

public class GameGrid {


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
                System.out.printf("X\t");
                break;
            case 2:
                System.out.printf("O\t");
                break;
            case 10:
                System.out.printf("*\t");
                break;
            default:
                System.out.printf("error\t");
                break;
        }
    }

    /**
     * Method to build the initial grid for connect 4 without any player counters.
     * <p>The grid value '-1' denotes an empty cell which does not contain a player counter</p>
     * @param numberColumns - number of columns in the connect 4 game grid
     * @param columnHeight - height of the columns in the connect 4 game grid
     * @return - 2D integer (initially 'empty' with '-1' in each cell) game grid to store positions of the counters
     */
    public static int[][] buildInitialGrid(final int numberColumns, final int columnHeight)
    {


        int[][] grid = new int[numberColumns][columnHeight];

        for(int i = 0; i < numberColumns; i++)
        {
            grid[i] = buildUnpopulatedStartColumn(columnHeight);
        }

        return grid;
    }

    /**
     * Method to build a single empty column for the connect 4 grid
     * @param columnHeight
     * @return integer array initiallly filled with 'empty' '-1' values, will be a column to store player counters
     */
    public static int[] buildUnpopulatedStartColumn(final int columnHeight)
    {
        int[] column = new int[columnHeight];

        for(int i=0; i<columnHeight; i++)
        {
            column[i] = -1; // if the cell contains -1 it means it is empty
        }

        return column;
    }

}




