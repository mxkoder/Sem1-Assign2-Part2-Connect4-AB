package org.example;


import org.example.Counters.Counter;
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

        //Taking turns
        while(true){
            printPlayersAndGrid(player1, player2, gameGrid);
            Turn.playerTakesTurn(player1, gameGrid);
            System.out.printf("\n");

            printPlayersAndGrid(player1, player2, gameGrid);
            Turn.playerTakesTurn(player2, gameGrid);
            System.out.printf("\n");
        }
    }

    public static void printPlayersAndGrid (Player player1, Player player2, int [][] gameGrid){

        PrintPlayer.displayPlayers(player1, player2);
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }
}