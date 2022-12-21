package org.example.Turn;

import org.example.Player.Player;
import org.example.UserInputs.ReadInput;

public class Turn {

    public static void playerTakesTurn (Player player, int[][] gameGrid){

        int selectedColumnIndex = playerSelectColumnPrompt(player,gameGrid);
        int[] selectedColumn = gameGrid[selectedColumnIndex];

        int playerCounterNumber = player.getCounter().getCounterNumber();

        TurnMechanism.takeTurnDropCounter(playerCounterNumber, selectedColumn);
    }

    public static int playerSelectColumnPrompt (Player player, int[][] gameGrid){

        int playerCounterNumber = player.getCounter().getCounterNumber();

        int minColumnNumber = 0;
        int maxColumnNumber = gameGrid.length;

        System.out.printf("Player %d Select Column:", playerCounterNumber);
        int selectedColumn = ReadInput.readIntFromConsoleInRangeWithPrompt(
                minColumnNumber,
                maxColumnNumber,
                "Please select a valid column by entering an integer between");

        return selectedColumn;
    }

}
