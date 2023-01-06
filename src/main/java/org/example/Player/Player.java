package org.example.Player;

import org.example.Counters.Counter;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;

public class Player {

    private Counter counter;
    private SpecialMove blitz;
    private SpecialMove timeBomb;

    /**
     * Player object constructor to be used to initialise the two players for the Connect 4 game
     * @param counter Counter object - a Counter object with an associated number and symbol for the game grid
     */
    public Player(Counter counter){

        if( counter.getCounterNumber() == 1 | counter.getCounterNumber() == 2) {

            this.counter = counter;
            this.blitz = Blitz.blitzInitialise();
            this.timeBomb = TimeBomb.timeBombInitialise();
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

    public SpecialMove getTimeBomb () {
        return timeBomb;
    }

    public void setTimeBomb (SpecialMove timeBomb) {
        this.timeBomb = timeBomb;
    }

}
