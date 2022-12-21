import org.example.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PlayerTest {

    @Test
    void createNewPlayerTest () {

        Player player1 = new Player(1,1,1);
        assertEquals(1, player1.getCounter());
        assertEquals(1, player1.getBlitzMoves());
        assertEquals(1, player1.getTimeBombMoves());

        Player player2 = new Player(2,1,1);
        assertEquals(2, player2.getCounter());
        assertEquals(1, player2.getBlitzMoves());
        assertEquals(1, player2.getTimeBombMoves());
    }

    @Test
    void createNewPlayerInvalidCounterTest () {

        Player player3 = new Player(3, 1,1);
        assertEquals(-1, player3.getCounter());

        Player player4 = new Player(0, 1,1);
        assertEquals(-1, player4.getCounter());

        Player player5 = new Player(10, 1,1);
        assertEquals(-1, player5.getCounter());

        Player player6 = new Player(100, 1,1);
        assertEquals(-1, player6.getCounter());
    }



}

