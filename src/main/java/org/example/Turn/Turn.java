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

    public static void main(String[] args) {

        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player1 = new Player( counter1X, blitz, timeBomb);
        Player player2 = new Player(counter2O, blitz, timeBomb);



        int[][] gameGrid = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 2, 2, 2, 2, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1}
        };

        PrintGrid.printGridWithColumnHeadings(gameGrid);

        interpretPlayerCommand(player1, player2, gameGrid);

        System.out.printf("after move \n");
        PrintGrid.printGridWithColumnHeadings(gameGrid);
    }

    //TODO - below has been refactored-  check tests valid, check method calls

    public static void interpretPlayerCommand (Player turnPlayer, Player otherPlayer, int[][] gameGrid) {

        playerSelectColumnPrompt(turnPlayer);
        String playerInput = stdin.nextLine();

        //TODO check what if enter non integer eg 1uioy3?, or A123B?
        if(playerInput.matches("^[0-9]*$")) {
            int selectedColumnIndex = Integer.parseInt(playerInput);

            //System.out.printf("selected column index is %d \n", selectedColumnIndex);

            boolean indexIsValid = checkColumnIndex(gameGrid,selectedColumnIndex, turnPlayer, otherPlayer);

            if(indexIsValid) {
                playerTakesNormalTurn(turnPlayer, gameGrid, selectedColumnIndex);

            } else {
                errorMessageInvalidCommand();
                interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);
            }

        } else if (playerInput.matches("^[a-zA-Z]*$")) {
            String moveCommand = playerInput.toUpperCase();
            SpecialMove.specialMoveCommand(moveCommand, turnPlayer, otherPlayer, gameGrid);

        } else {
            errorMessageInvalidCommand();
            interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        }
    }


    //TODO add java doc method explanations
    public static void playerTakesNormalTurn (Player player, int[][] gameGrid, int selectedColumnIndex){

        boolean turnTaken = false;

        int[] selectedColumn = gameGrid[selectedColumnIndex];

        int playerCounterNumber = player.getCounter().getCounterNumber();

        turnTaken = TurnMechanism.takeTurnDropCounter(playerCounterNumber, selectedColumn);

        if(!turnTaken){

            errorMessageInvalidCommand();
            playerTakesNormalTurn(player, gameGrid, selectedColumnIndex);
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

        System.out.printf("Please enter a either a valid column index number or a single letter command for a special move. \n");
    }


}
