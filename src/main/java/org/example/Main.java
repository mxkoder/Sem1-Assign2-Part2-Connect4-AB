package org.example;


import org.example.Counters.Counter;
import org.example.GamePlay.GamePlay;
import org.example.GamePlay.GameReplay;
import org.example.Player.Player;

import java.util.*;


public class Main {



    public static void main(String[] args) {

        // Player and Counters setup
        Counter counter1X = Counter.counter1X();
        Counter counter2O = Counter.counter2O();

        //TODO special moves - need to make sure players are re initialised to
        // starting no special moves if replay

        //TODO - change hardcoded special move numbers to set methods / make an 'initialise player' method?s
        Player player1 = new Player( counter1X, 1, 1);
        Player player2 = new Player(counter2O, 1, 1);

        //Initialising game grid
        int [][] gameGrid = GamePlay.initialise6x6GridAndPrintWithPlayers(player1, player2);

        // Play game until win or draw
        GamePlay.choosePlayerPlayGame(player1, player2, gameGrid);

        //Option to play the game again
        GameReplay.optionToPlayAgain(player1, player2);

        //TODO - check game draw again

    }

}