package org.example.GamePlay;

import org.example.GameEnd.Draw;
import org.example.GameEnd.GameWin;
import org.example.Grid.BuildGrid;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.Player.PrintPlayer;
import org.example.Turn.Turn;
import org.example.UserInputs.ReadInput;

public class GamePlay {

    /**
     * Method to allow the players to decide who will take the first turn in the Connect4 game
     * <P> The method switches the player to go first by changing the order of the player arguments inputted
     * into GamePlay.playGamePrintResult</P>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @param gameGrid - 2D integer game grid to store positions of the Connect4 counters
     */
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
                    System.out.printf("Invalid input. Please enter either 1 or 2: ");
            }
        }
    }

    /**
     * Method to enable players 1 and 2 to play a game of Connect4, and print out the end game result
     * <P>Players take turns to drop counters into the Connect4 for grid until one of the end game conditions is met.
     * If a player gets 4 of their counters in a horizontal, vertical, or diagonal row, they have won the game.
     * If neither player wins but the game grid if full, the game is a draw.</P>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @param gameGrid - 2D integer game grid to store positions of the Connect4 counters
     */
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


    /**
     * Method to print and initialise a 6 x 6 empty game grid along with a summary of Player1 and Player2.
     * <p>The game grid can then be used to store and display the positions of the two players' counters
     * as the Connect4 game progresses</p>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @return - - 2D 'empty' integer game grid to store positions of the Connect4 counters
     */
    public static int [][] initialise6x6GridAndPrintWithPlayers (Player player1, Player player2) {

        int[][] emptyGameGrid = BuildGrid.buildInitialGrid(6,6);
        printPlayersAndGrid(player1, player2, emptyGameGrid);

        return emptyGameGrid;
    }

    /**
     * Method to print both players and their counters and the Connect4 game grid
     * <p>The game grid will be printed with the current status of player counters</p>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @param gameGrid - 2D integer game grid to store positions of the Connect4 counters
     */
    public static void printPlayersAndGrid (Player player1, Player player2, int [][] gameGrid){

        PrintPlayer.displayPlayers(player1, player2);
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }
}
