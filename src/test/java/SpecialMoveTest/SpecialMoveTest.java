package SpecialMoveTest;

import org.example.SpecialMoves.SpecialMove;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialMoveTest {

    @Test
    public void useUp1MoveBooleanTest () {

        SpecialMove blitz1 = new SpecialMove(-1,'-',1,"B");
        assertEquals(true, blitz1.useUp1Move());


        SpecialMove timeBomb1 = new SpecialMove(10,'*',1,"T");
        assertEquals(true, timeBomb1.useUp1Move());

        // With no special moves left to use:
        SpecialMove blitz2 = new SpecialMove(-1,'-',0,"B");
        assertEquals(false, blitz2.useUp1Move());

        SpecialMove timeBomb2 = new SpecialMove(10,'*',0,"T");
        assertEquals(false, timeBomb2.useUp1Move());
    }

    @Test
    public void useUp1MoveReduceMovesTest () {
        SpecialMove blitz1 = new SpecialMove(-1,'-',1,"B");
        blitz1.useUp1Move();
        assertEquals(0, blitz1.getNumberOfMoves());

        SpecialMove timeBomb1 = new SpecialMove(10,'*',1,"T");
        timeBomb1.useUp1Move();
        assertEquals(0, timeBomb1.getNumberOfMoves());

        SpecialMove blitz2 = new SpecialMove(-1,'-',0,"B");
        blitz2.useUp1Move();
        assertEquals(0, blitz2.getNumberOfMoves());

        SpecialMove timeBomb2 = new SpecialMove(10,'*',0,"T");
        timeBomb2.useUp1Move();
        assertEquals(0, timeBomb2.getNumberOfMoves());
    }
}
