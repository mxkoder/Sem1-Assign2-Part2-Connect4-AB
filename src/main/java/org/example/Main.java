package org.example;


import org.example.Counters.Counter;
import org.example.GamePlay.GamePlay;
import org.example.GamePlay.GameReplay;
import org.example.Player.Player;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;

import java.util.*;


public class Main {



    public static void main(String[] args) {

        //TODO - change hardcoded special move numbers to set methods / make an 'initialise player' method?s

        // Player and Counters setup
        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player1 = new Player( counter1X, blitz, timeBomb);
        Player player2 = new Player(counter2O, blitz, timeBomb);

        //Initialising game grid
        int [][] gameGrid = GamePlay.initialise6x6GridAndPrintWithPlayers(player1, player2);

        // Play game until win or draw
        GamePlay.choosePlayerPlayGame(player1, player2, gameGrid);

        //Option to play the game again
        GameReplay.optionToPlayAgain(player1, player2);

        //TODO - check game draw again

    }

}