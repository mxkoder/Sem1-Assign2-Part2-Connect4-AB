package org.example.GamePlay;

import org.example.GameEnd.Draw;
import org.example.GameEnd.GameWin;
import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.Player.PrintPlayer;
import org.example.Turn.Turn;
import org.example.UserInputs.ReadInput;

//TODO tidy up? javadoc & test more
public class GamePlay {

    public static void choosePlayerPlayGame (Player player1, Player player2, int [][] gameGrid){

        int choice;
        boolean validInput = false;

        System.out.printf("Who would like to go first for this game of Connect4? \n" +
                "Please enter: \n" +
                "1 - for Player1 \n" +
                "2  - for Player2 \n" +
                "First player: \n");

        while(!validInput){
            choice = ReadInput.readIntFromConsoleNoPrompt();

            switch(choice){
                case 1:
                    System.out.printf("You have chosen for player 1 to go first. \n");
                    GamePlay.playGamePrintResult(player1, player2, gameGrid);
                    validInput = true;
                    break;

                case 2:
                    System.out.printf("You have chosen for player 2 to go first. \n");
                    GamePlay.playGamePrintResult(player2, player1, gameGrid);
                    validInput = true;
                    break;

                default:
                    System.out.printf("Invalid input. Please enter either 1 or 2. \n");
            }
        }
    }

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
}
