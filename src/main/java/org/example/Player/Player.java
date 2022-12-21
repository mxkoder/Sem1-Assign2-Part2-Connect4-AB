package org.example.Player;

import org.example.Counters.Counter;

public class Player {

    private Counter counter;
    private int blitzMoves;
    private int timeBombMoves;

    /**
     * Player object to be used to initialise the two players for the connect 4 game
     * @param counter Counter object - a Counter object with an associated number for the gird value and symbol
     * @param blitzMoves Integer - number of special 'Blitz Moves' the player has available
     * @param timeBombMoves Integer - number of special 'Time Bomb Moves' the player has available
     */
    public Player(Counter counter, int blitzMoves, int timeBombMoves){

        if( counter.getCounterNumber() == 1 | counter.getCounterNumber() == 2) {

            this.counter = counter;
            this.blitzMoves = blitzMoves;
            this.timeBombMoves = timeBombMoves;
        } else {
            System.out.printf("Please choose a valid counter number of either 1 (X) or 2 (O) \n");
        }
    }

    public Counter getCounter () {
        return counter;
    }

    public int getBlitzMoves () {
        return blitzMoves;
    }

    public int getTimeBombMoves () {
        return timeBombMoves;
    }
}
