package org.example.GamePlay;

import org.example.Player.Player;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;

import java.util.Scanner;

public class GameReplay {

    private static Scanner stdin = new Scanner(System.in);


    /**
     * Call the gameReplay method in a loop until the players choose not to play again
     * <p>The gameReplay method will return false if the players choose not to play again, and the loop in the
     * the optionToPlayAgain method will then be exited.
     * </p>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     */
    public static void optionToPlayAgain (Player player1, Player player2) {
        boolean chooseToReplay;
        do {
            chooseToReplay = gameReplay(player1, player2);

        } while (chooseToReplay);

    }


    /**
     * Method to give the players an option to play another game of Connect4
     * <p>The players are offered a Y or N choice to play again.
     * If they choose to play again, a new game grid will be initialised, player special moves will be reset, and game play will begin again. </p>
     * @param player1 - Player object with associated counter and special moves
     * @param player2 - Player object with associated counter and special moves
     * @return boolean - 'true' if the game should be played again, 'false' if the game is not to be replayed.
     */
    public static boolean gameReplay (Player player1, Player player2){

        String choice;

        System.out.printf("Would you like to play another game of Connect4 ? \n");

        while(true){
            System.out.printf("Please enter Y or N: \n");
            choice = stdin.nextLine().toUpperCase();

            switch(choice){
                case "Y":
                    System.out.printf("You have chosen to play another game of Connect4. \n");

                    int [][] gameGrid = GamePlay.initialise6x6GridAndPrintWithPlayers(player1, player2);

                    resetPlayer(player1);
                    resetPlayer(player2);

                    GamePlay.choosePlayerPlayGame(player1, player2, gameGrid);
                    return true;

                case "N":
                    System.out.printf("Thank you for playing Connect4, you have chosen not to play another game. \n");
                    return false;

                default:
                    System.out.printf("Invalid input. \n");
            }
        }
    }

    /**
     * Method to reset players to their original Special Move settings
     * <p>Players keep the same counters</p>
     * @param player Player object with associated counter and special moves
     */
    public static void resetPlayer (Player player) {

        player.setBlitz(Blitz.blitzInitialise());
        player.setTimeBomb(TimeBomb.timeBombInitialise());
    }

}
