package org.example.SpecialMoves;

import org.example.Counters.Counter;
import org.example.Player.Player;

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

    public static void useUp1Move ( SpecialMove specialMoveObject) {
        specialMoveObject.numberOfMoves -= 1;
    }

    public static void specialMoveCommand (String command, Player player1,Player player2, int[][] gameGrid) {

        if(command == Blitz.blitzInitialise().getMoveCommand()) {
            Blitz.blitzMoveDialogue(gameGrid);
        }
    }

}


