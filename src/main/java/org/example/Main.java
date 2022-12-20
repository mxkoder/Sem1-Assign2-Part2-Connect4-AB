package org.example;

import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;

import java.util.*;


public class Main {

    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] gameGrid = BuildGrid.buildInitialGrid(6,6);

        PrintGrid.printGridWithColumnHeadings(gameGrid);

    }
}