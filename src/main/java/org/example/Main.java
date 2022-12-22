package org.example;


import org.example.Counters.Counter;
import org.example.GameWin.GameWin;
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
        Player player2 = new Player(counter2O,1,1);

        //Initialising game grid
        int[][] gameGrid = BuildGrid.buildInitialGrid(6,6);

        //Print grid and players
//        printPlayersAndGrid(player1, player2, gameGrid);

        //TODO check while loop is the right way round
        //TODO make separate method
        //Taking turns
        printPlayersAndGrid(player1, player2, gameGrid);

        do {
            Turn.playerTakesTurn(player1, gameGrid);
            System.out.printf("\n");

            if(GameWin.haveWinner(gameGrid)) {
                printPlayersAndGrid(player1, player2, gameGrid);
                break;
            }

            printPlayersAndGrid(player1, player2, gameGrid);
            Turn.playerTakesTurn(player2, gameGrid);
            System.out.printf("\n");

            printPlayersAndGrid(player1, player2, gameGrid);
        } while(!GameWin.haveWinner(gameGrid));

        //TODO make separate method for this?
        // change so that method returns the wining player object
        //Deciding winner
        int winningCounterInteger = GameWin.winningCounterInteger(gameGrid);

        if (player1.getCounter().getCounterNumber() == winningCounterInteger) {

            System.out.printf("Congratulations!! Player %d you have won the game \n", player1.getCounter().getCounterNumber());

        } else if (player2.getCounter().getCounterNumber() == winningCounterInteger) {
            System.out.printf("Congratulations!! Player %d you have won the game \n", player2.getCounter().getCounterNumber());
        }


        //TODO - add option to play the game again?

    }

    public static void printPlayersAndGrid (Player player1, Player player2, int [][] gameGrid){

        PrintPlayer.displayPlayers(player1, player2);
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }
}