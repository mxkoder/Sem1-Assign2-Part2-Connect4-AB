package org.example;

import org.example.Game.GameGrid;

import java.util.*;


public class Main {

    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] gameGrid = GameGrid.buildInitialGrid(6,6);

        GameGrid.printGridWithColumnHeadings(gameGrid);

    }
}