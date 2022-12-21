package org.example.Player;

import org.example.Grid.PrintGrid;

public class Player {

    private int counter = -1;
    private int blitzMoves;
    private int timeBombMoves;

    /**
     * Player object to be used to initialise the two players for the connect 4 game
     * <p>The Player will initialise with a '-1' value for a counter is no valid counter (either 1 or 2) is selected.</p>
     * @param counter Integer - input which should have a value of 1 (represents X) or 2 (represents O)
     * @param blitzMoves Integer - number of special 'Blitz Moves' the player has available
     * @param timeBombMoves Integer - number of special 'Time Bomb Moves' the player has available
     */
    public Player(int counter, int blitzMoves, int timeBombMoves){

        if(counter == 1 | counter == 2) {

            this.counter = counter;
            this.blitzMoves = blitzMoves;
            this.timeBombMoves = timeBombMoves;
        } else {
            System.out.printf("Please choose a valid counter number of either 1 (X) or 2 (O) \n");
        }
    }

    public int getCounter () {
        return counter;
    }

    public int getBlitzMoves () {
        return blitzMoves;
    }

    public int getTimeBombMoves () {
        return timeBombMoves;
    }
}
