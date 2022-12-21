package PlayerTest;

import org.example.Counters.Counter;
import org.example.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PlayerTest {

    @Test
    void createNewPlayerTest () {

        Counter counter1X = Counter.counter1X();
        Player player1 = new Player(counter1X,1,1);
        assertEquals(1, player1.getCounter().getCounterNumber());
        assertEquals(1, player1.getBlitzMoves());
        assertEquals(1, player1.getTimeBombMoves());

        Counter counter2O = Counter.counter2O();
        Player player2 = new Player(counter2O,1,1);
        assertEquals(2, player2.getCounter().getCounterNumber());
        assertEquals(1, player2.getBlitzMoves());
        assertEquals(1, player2.getTimeBombMoves());
    }

    @Test
    void createNewPlayerInvalidCounterTest () {

        Player player3 = new Player(new Counter(3, 'x'), 1,1);
        assertEquals(null, player3.getCounter());

        Player player4 = new Player(new Counter(0, 'x'), 1,1);
        assertEquals(null, player4.getCounter());

        Player player5 = new Player(new Counter(10, 'x'), 1,1);
        assertEquals(null, player5.getCounter());

        Player player6 = new Player(new Counter(100, 'x'), 1,1);
        assertEquals(null, player6.getCounter());
    }

}

