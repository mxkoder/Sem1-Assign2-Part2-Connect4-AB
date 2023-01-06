package org.example;

import org.example.Counters.Counter;
import org.example.GamePlay.GamePlay;
import org.example.GamePlay.GameReplay;
import org.example.Player.Player;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;

public class Main {

    public static void main(String[] args) {

        // Player and Counters setup
        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        Player player1 = new Player(counter1X);
        Player player2 = new Player(counter2O);

        //Initialising game grid
        int [][] gameGrid = GamePlay.initialise6x6GridAndPrintWithPlayers(player1, player2);

        // Play game until win or draw
        GamePlay.choosePlayerPlayGame(player1, player2, gameGrid);

        //Option to play the game again
        GameReplay.optionToPlayAgain(player1, player2);

    }
}