package PlayerTest;

import org.example.Counters.Counter;
import org.example.Player.Player;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class PlayerTest {

    @Test
    void createNewPlayerTest () {

        Counter counter1X = Counter.counter1X();

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player1 = new Player(counter1X);
        assertEquals(1, player1.getCounter().getCounterNumber());
        assertEquals(1, player1.getBlitz().getNumberOfMoves());
        assertEquals(1, player1.getTimeBomb().getNumberOfMoves());

        Counter counter2O = Counter.counter2O();
        Player player2 = new Player(counter2O);
        assertEquals(2, player2.getCounter().getCounterNumber());
        assertEquals(1, player2.getBlitz().getNumberOfMoves());
        assertEquals(1, player2.getBlitz().getNumberOfMoves());
    }

    @Test
    void createNewPlayerInvalidCounterTest () {

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player3 = new Player(new Counter(3, 'x'));
        assertNull(player3.getCounter());

        Player player4 = new Player(new Counter(0, 'x'));
        assertNull(player4.getCounter());

        Player player5 = new Player(new Counter(10, 'x'));
        assertNull(player5.getCounter());

        Player player6 = new Player(new Counter(100, 'x'));
        assertNull(player6.getCounter());
    }

}

