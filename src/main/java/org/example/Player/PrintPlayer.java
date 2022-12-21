package org.example.Player;

import org.example.Grid.PrintGrid;

public class PrintPlayer {

    /**
     * Method to print two players to the console
     * <p>Will print each player in the format 'Player [player number] [player counter symbol] [new line]</p>
     * @param player1 - Player object which is to be printed
     * @param player2 - Player object which is to be printed
     */
    public static void displayPlayers (Player player1, Player player2){

        printSinglePlayer(player1);
        printSinglePlayer(player2);
    }


    /**
     * Method to print a single player to the console
     * <p>Will print in the format 'Player [player number] [player counter symbol] [new line]</p>
     * @param playerToPrint - Player object which is to be printed
     */
    public static void printSinglePlayer (Player playerToPrint){

        if(playerToPrint.getCounter() == 1 | playerToPrint.getCounter() == 2) {

            System.out.printf("Player %d ", playerToPrint.getCounter());
            PrintGrid.displayCounterInGrid(playerToPrint.getCounter());
            System.out.printf("\n");
        } else {

            System.out.printf("Please initialise players first with valid counter number either 1 (X) or 2 (O). \n");
        }
    }
}
