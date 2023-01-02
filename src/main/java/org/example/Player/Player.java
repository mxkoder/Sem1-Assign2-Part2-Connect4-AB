package org.example.Player;

import org.example.Counters.Counter;
import org.example.SpecialMoves.SpecialMove;

public class Player {

    private Counter counter; // TODO add ID for player number? Here, counter number is the same as the player number
    private SpecialMove blitz; //TODO make edits - changed to object here
    private int timeBombMoves;

    /**
     * Player object to be used to initialise the two players for the connect 4 game
     * @param counter Counter object - a Counter object with an associated number for the gird value and symbol
     * @param blitzMoves Integer - number of special 'Blitz Moves' the player has available
     * @param timeBombMoves Integer - number of special 'Time Bomb Moves' the player has available
     */
    public Player(Counter counter, SpecialMove blitz, int timeBombMoves){

        if( counter.getCounterNumber() == 1 | counter.getCounterNumber() == 2) {

            this.counter = counter;
            this.blitz = blitz;
            this.timeBombMoves = timeBombMoves;
        } else {
            System.out.printf("Please choose a valid counter number of either 1 (X) or 2 (O) \n");
        }
    }

    public Counter getCounter () {
        return counter;
    }

    public SpecialMove getBlitz () {
        return blitz;
    }

    public void setBlitz (SpecialMove blitz) {
        this.blitz = blitz;
    }

    public int getTimeBombMoves () {
        return timeBombMoves;
    }

}
