package org.example;


import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.Player.PrintPlayer;

import java.util.*;


public class Main {

    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        Player player1 = new Player(1, 1, 1);
        Player player2 = new Player(2,1,1);

        PrintPlayer.displayPlayers(player1, player2);

        int[][] gameGrid = BuildGrid.buildInitialGrid(6,6);

        PrintGrid.printGridWithColumnHeadings(gameGrid);


    }
}