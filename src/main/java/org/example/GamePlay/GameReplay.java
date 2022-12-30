package org.example.GamePlay;

import org.example.Player.Player;

import java.util.Scanner;

public class GameReplay {

    private static Scanner stdin = new Scanner(System.in);

    public static void optionToPlayAgain (Player player1, Player player2) {
        boolean chooseToReplay;
        do {
            chooseToReplay = gameReplay(player1, player2);

        } while (chooseToReplay);

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
                    int [][] gameGrid = GamePlay.initialise6x6GridAndPrintWithPlayers(player1, player2);
                    GamePlay.choosePlayerPlayGame(player1, player2, gameGrid);
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
