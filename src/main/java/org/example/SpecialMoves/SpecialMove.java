package org.example.SpecialMoves;

import org.example.Counters.Counter;
import org.example.Player.Player;
import org.example.Turn.Turn;

public class SpecialMove {


    private int moveNumberInGrid;
    private Character moveSymbolInGrid;
    private int numberOfMoves;
    private String moveCommand;

    public SpecialMove (int moveNumberInGrid, Character moveSymbolInGrid, int numberOfMoves, String moveCommand){

        this.moveNumberInGrid = moveNumberInGrid;
        this.moveSymbolInGrid = moveSymbolInGrid;
        this.numberOfMoves = numberOfMoves;
        this.moveCommand = moveCommand;
    }

    public int getMoveNumberInGrid () {
        return moveNumberInGrid;
    }

    public Character getMoveSymbolInGrid () {
        return moveSymbolInGrid;
    }

    public int getNumberOfMoves () {
        return numberOfMoves;
    }

    public String getMoveCommand () {
        return moveCommand;
    }

    public boolean useUp1Move () {

        if(this.numberOfMoves < 1) {
            return false;
        }

        this.numberOfMoves -= 1;
        return true;
    }

    public static void specialMoveCommand (String command, Player turnPlayer,Player otherPlayer, int[][] gameGrid) {

        if(command.equals(Blitz.blitzInitialise().getMoveCommand()) ) {
            Blitz.blitzMoveDialogue(gameGrid, turnPlayer, otherPlayer);

        } else {
            System.out.printf("Invalid command. Please enter either a column index to drop your counter or a valid special move command.\n");
            Turn.interpretPlayerCommand(turnPlayer, otherPlayer, gameGrid);

        }
    }

}


