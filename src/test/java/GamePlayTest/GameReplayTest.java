package GamePlayTest;

import org.example.Counters.Counter;
import org.example.GamePlay.GameReplay;
import org.example.Player.Player;
import org.example.SpecialMoves.Blitz;
import org.example.SpecialMoves.SpecialMove;
import org.example.SpecialMoves.TimeBomb;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameReplayTest {

    @Test
    public void resetPlayersTimeBombTest () {


        Counter counter1X = Counter.counter1X();

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player = new Player( counter1X, blitz, timeBomb);


        player.getTimeBomb().useUp1Move();


        GameReplay.resetPlayer(player);
        assertEquals(1, player.getTimeBomb().getNumberOfMoves());

    }

    @Test
    public void resetPlayersBlitzTest () {

        Counter counter1X = Counter.counter1X();

        SpecialMove blitz = Blitz.blitzInitialise();
        SpecialMove timeBomb = TimeBomb.timeBombInitialise();

        Player player = new Player( counter1X, blitz, timeBomb);


        player.getBlitz().useUp1Move();


        GameReplay.resetPlayer(player);
        assertEquals(1, player.getBlitz().getNumberOfMoves());

    }
}
