package org.example.Game;

import java.lang.ref.PhantomReference;

public class GameGrid {


    public static void main(String[] args) {
        //DONE build initial column

        //DONE build initial grid


        // print grid

        int[][] gameGrid = buildInitialGrid(6,6);

//        gameGrid[2][5]= 2;
//        gameGrid[3][5]= 1;

//        printGridColumnHeadings(gameGrid);
//        printGrid(gameGrid);

        printGridWithColumnHeadings(gameGrid);

        // print grid with column headings
    }

    public static void printGridWithColumnHeadings (int [][] grid){
        printGridColumnHeadings(grid);
        printGrid(grid);
    }

    public static void printGridColumnHeadings(int [][] grid){

        for(int i = 0; i < grid.length ; i++)
        {
            System.out.printf("%d\t", i);
        }

        System.out.print("\n");

    }

    public static void printGrid(int[][] grid)
    {
        for(int i = 0; i < grid[0].length; i++)
        {
            for(int j = 0; j< grid.length; j++)
            {
                displayMoveInGrid(grid[j][i]);
            }
            System.out.print("\n");
        }
    }

    public static void displayMoveInGrid ( int gridValue) {
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

    public static int[][] buildInitialGrid(final int numberColumns, final int columnHeight)
    {


        int[][] grid = new int[numberColumns][columnHeight];

        for(int i = 0; i < numberColumns; i++)
        {
            grid[i] = buildUnpopulatedStartColumn(columnHeight);
        }

        return grid;
    }

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




