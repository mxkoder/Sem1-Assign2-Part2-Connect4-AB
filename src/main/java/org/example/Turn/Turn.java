package org.example.Turn;

import org.example.Player.Player;
import org.example.UserInputs.ReadInput;

public class Turn {

    public static void playerTakesTurn (Player player, int[][] gameGrid){

        boolean turnTaken = false;

        int selectedColumnIndex = playerSelectColumnPrompt(player, gameGrid);
        int[] selectedColumn = gameGrid[selectedColumnIndex];

        int playerCounterNumber = player.getCounter().getCounterNumber();

            turnTaken = TurnMechanism.takeTurnDropCounter(playerCounterNumber, selectedColumn);

        if(!turnTaken){

            System.out.printf("Please make sure you have selected a column that has space for a counter and is not full. \n");
            playerTakesTurn(player, gameGrid);
        }
    }

    public static int playerSelectColumnPrompt (Player player, int[][] gameGrid){

        int playerCounterNumber = player.getCounter().getCounterNumber();

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length - 1;

        System.out.printf("Player %d Select Column:", playerCounterNumber);
        int selectedColumn = ReadInput.readIntFromConsoleInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                "Please select a valid column by entering an integer between");

        return selectedColumn;
    }

}
