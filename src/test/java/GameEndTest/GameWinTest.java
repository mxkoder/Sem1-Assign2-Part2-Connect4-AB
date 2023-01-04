package GameEndTest;

import org.example.GameEnd.GameWin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameWinTest {

    @Test
    public void haveWinnerTest (){

        int[][] gameGrid1 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        assertEquals(true, GameWin.haveWinner(gameGrid1));


        int[][] gameGrid2 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(false, GameWin.haveWinner(gameGrid2));


        int[][] gameGrid3 = {
                {1, 1, 2, 2, 1, 2},
                {1, 2, 1, 1, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 2, 1, 2, 2, 1},
                {1, 1, 2, 1, 1, 2},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(false, GameWin.haveWinner(gameGrid3));

        int[][] gameGrid4 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(false, GameWin.haveWinner(gameGrid4));

        // Winning row
        int [][] gameGrid5 = {
            {-1, -1, -1, 1, -1, 1},
            {-1, -1, -1, -1, -1, 1},
            {-1, -1, -1, -1, -1, 1},
            {-1, -1, -1, -1, -1, 1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(true, GameWin.haveWinner(gameGrid5));


        //Winning column
        int[][] gameGrid6 = {
                {-1, -1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(true, GameWin.haveWinner(gameGrid6));


        // Wining diagonal
        int[][] gameGrid7 = {
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(true, GameWin.haveWinner(gameGrid7));

    }

    @Test
    public void winningCounterIntegerTest () {

        int[][] gameGrid1 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        assertEquals(1, GameWin.winningCounterInteger(gameGrid1));


        int[][] gameGrid2 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, GameWin.winningCounterInteger(gameGrid2));


        int[][] gameGrid3 = {
                {1, 1, 2, 2, 1, 2},
                {1, 2, 1, 1, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 2, 1, 2, 2, 1},
                {1, 1, 2, 1, 1, 2},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(-1, GameWin.winningCounterInteger(gameGrid3));

        int[][] gameGrid4 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(-1, GameWin.winningCounterInteger(gameGrid4));

        // Winning row
        int [][] gameGrid5 = {
                {-1, -1, -1, 1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, GameWin.winningCounterInteger(gameGrid5));


        //Winning column
        int[][] gameGrid6 = {
                {-1, -1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, GameWin.winningCounterInteger(gameGrid6));


        // Wining diagonal
        int[][] gameGrid7 = {
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, GameWin.winningCounterInteger(gameGrid7));
    }

}