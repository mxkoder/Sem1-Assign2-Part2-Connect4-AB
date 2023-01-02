package org.example.Player;

import org.example.Counters.Counter;
import org.example.SpecialMoves.SpecialMove;

public class Player {

    //TODO - change java comments to reflect changes in blitz & time bomb
    private Counter counter;
    private SpecialMove blitz;
    private SpecialMove timeBomb;

    /**
     * Player object to be used to initialise the two players for the connect 4 game
     * @param counter Counter object - a Counter object with an associated number for the gird value and symbol
     * @param blitz SpecialMove - blitz special move object
     * @param timeBomb SpecialMove - time bomb object
     */
    public Player(Counter counter, SpecialMove blitz, SpecialMove timeBomb){

        if( counter.getCounterNumber() == 1 | counter.getCounterNumber() == 2) {

            this.counter = counter;
            this.blitz = blitz;
            this.timeBomb = timeBomb;
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
