package org.example.Game;

public class GameGrid {


    public static void main(String[] args) {
        //DONE build initial column

        //DONE build initial grid


        // print grid

        int[][] gameGrid = buildInitialGrid(6,6);

//        gameGrid[2][5]= 2;
//        gameGrid[3][5]= 1;

        printGrid(gameGrid);

        // print grid with column headings
    }

    public static void printGrid(int[][] grid)
    {
        for(int i = 0; i < grid[0].length; i++)
        {
            for(int j = 0; j< grid.length; j++)
            {
                switch (grid[j][i]) {

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
                        System.out.printf("error.\n");
                        break;
                }
            }
            System.out.print("\n");
        }
    }

    public static int[][] buildInitialGrid(final int numberColumns, final int columnHeight)
    {


        int[][] grid = new int[columnHeight][numberColumns];

        for(int i = 0; i < numberColumns; i++)
        {
            grid[i] = buildUnpopulatedStartColumn(numberColumns);
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




