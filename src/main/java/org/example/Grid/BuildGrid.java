package org.example.Grid;

public class BuildGrid {

    /**
     * Method to build the initial grid for connect 4 without any player counters.
     * <p>The grid value '-1' denotes an empty cell which does not contain a player counter</p>
     * @param numberColumns - number of columns in the Connect 4 game grid
     * @param columnHeight - height of the columns in the Connect 4 game grid
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
     * Method to build a single empty column for the Connect 4 grid
     * @param columnHeight - height of the columns in the Connect 4 game grid
     * @return integer array initially filled with 'empty' '-1' values, will be a column to store player counters
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

