package org.example;


import org.example.Counters.Counter;
import org.example.GameEnd.Draw;
import org.example.GameEnd.GameWin;
import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.Player.PrintPlayer;
import org.example.Turn.Turn;

import java.util.*;


public class Main {

    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        // Player and Counters setup
        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        Player player1 = new Player( counter1X, 1, 1);
        Player player2 = new Player(counter2O, 1, 1);

        //Initialising game grid
        int [][] gameGrid = initialise6x6GridAndPrintWithPlayers(player1, player2);

        // Play game until win or draw
        playGamePrintResult(player1, player2, gameGrid);

        //Option to play the game again
        boolean chooseToReplay;
        do {
            chooseToReplay = gameReplay(player1, player2);

        } while (chooseToReplay);

        //TODO - check game draw again

    }

    //TODO tidy up? javadoc & test more
    public static void playGamePrintResult (Player player1, Player player2, int [][] gameGrid) {

        do {
            Turn.playerTakesTurn(player1, gameGrid);
            System.out.printf("\n");

            if(GameWin.haveWinner(gameGrid) || Draw.gameIsADraw(gameGrid)) {
                printPlayersAndGrid(player1, player2, gameGrid);
                break;
            }

            printPlayersAndGrid(player1, player2, gameGrid);
            Turn.playerTakesTurn(player2, gameGrid);
            System.out.printf("\n");

            printPlayersAndGrid(player1, player2, gameGrid);
        } while(!GameWin.haveWinner(gameGrid) && !Draw.gameIsADraw(gameGrid));

        GameWin.printWinnerIfGameWon(player1, player2, gameGrid);

        Draw.printMessageIfGameDraw(gameGrid);

    }

    public static int [][] initialise6x6GridAndPrintWithPlayers (Player player1, Player player2) {

        int[][] emptyGameGrid = BuildGrid.buildInitialGrid(6,6);
        printPlayersAndGrid(player1, player2, emptyGameGrid);

        return emptyGameGrid;
    }

    public static void printPlayersAndGrid (Player player1, Player player2, int [][] gameGrid){

        PrintPlayer.displayPlayers(player1, player2);
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }

    //TODO keep here or move?
    public static boolean gameReplay (Player player1, Player player2){

        String choice;

        System.out.printf("Would you like to play another game of Connect4 ? \n");

        while(true){
            System.out.printf("Please enter Y or N: \n");
            choice = stdin.nextLine().toUpperCase();

            switch(choice){
                case "Y":
                    System.out.printf("You have chosen to play another game of Connect4. \n");

                    //TODO - if add more gameplay option, edit the method that's called here
                    int [][] gameGrid = initialise6x6GridAndPrintWithPlayers(player1, player2);
                    playGamePrintResult(player1, player2, gameGrid);

                    return true;
                case "N":
                    System.out.printf("Thank you for playing Connect4, you are now exiting the program. \n");
                    return false;
                default:
                    System.out.printf("Invalid input. \n");
            }
        }
    }
}