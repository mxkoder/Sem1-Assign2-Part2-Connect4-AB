package org.example.Turn;

import org.example.Counters.Counter;
import org.example.Grid.PrintGrid;
import org.example.Player.Player;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;
import org.example.UserInputs.ReadInput;

import java.util.*;

public class Turn {

    //TODO - add java doc, add tests where can
    private static Scanner stdin = new Scanner(System.in);

    //TODO - below has been refactored-  check tests valid, check method calls

    public static void interpretPlayerCommand (Player turnPlayer, Player otherPlayer, int[][] gameGrid) {

        playerSelectColumnPrompt(turnPlayer);
        String playerInput = stdin.nextLine();


        if(playerInput == "") {
            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        // Process for column index commands
        } else if(playerInput.matches("^[0-9]*$")) {
            int selectedColumnIndex = Integer.parseInt(playerInput);

            boolean indexIsValid = checkColumnIndex(gameGrid, selectedColumnIndex, turnPlayer, otherPlayer);

            // Checking if integer input by player is a valid column index
            if (indexIsValid) {
                playerTakesNormalTurn(turnPlayer, otherPlayer, gameGrid, selectedColumnIndex);

            } else {
                errorMessageInvalidCommand();
                interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);
            }

        // Process for Special Move letter commands
        } else if (playerInput.matches("^[a-zA-Z]*$")) {
            String moveCommand = playerInput.toUpperCase();
            SpecialMove.specialMoveCommand(moveCommand, turnPlayer, otherPlayer, gameGrid);

        } else {
            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        }
    }


    //TODO add java doc method explanations
    public static void playerTakesNormalTurn (Player turnPlayer, Player otherPlayer, int[][] gameGrid, int selectedColumnIndex){

        boolean turnTaken;

        int[] selectedColumn = gameGrid[selectedColumnIndex];

        int playerCounterNumber = turnPlayer.getCounter().getCounterNumber();

        turnTaken = TurnMechanism.takeTurnDropCounter(playerCounterNumber, selectedColumn);

        if(!turnTaken){

            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);
        }
    }

    public static void playerSelectColumnPrompt (Player player) {

        int playerCounterNumber = player.getCounter().getCounterNumber();

        System.out.printf("Player %d Select Column:", playerCounterNumber);

    }

    public static boolean checkColumnIndex (int[][] gameGrid, int selectedColumn, Player turnPlayer, Player otherPlayer) {

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length - 1;

        boolean columnIndexValid = ReadInput.checkIntIsInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                selectedColumn,
                "To drop a counter please select a valid column by entering an integer between");

        if(!columnIndexValid){

            return false;
        }

        return true;

    }

    public static void errorMessageInvalidCommand () {

        System.out.printf("Please enter a either a valid column index number or a single letter command for a special move. \n\n");
    }


}
