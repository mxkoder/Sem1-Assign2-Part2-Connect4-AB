package SpecialMoveTest;


import org.example.Counters.Counter;
import org.example.Player.Player;
import org.example.SpecialMoves.TimeBomb;
import org.example.Turn.TurnMechanism;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeBombTest {

    @Test
    public void timeBombExplosionTopRowsTest () {

        // Top row tests---------------------------------------------------------------------

        int[][] gameGrid1 = {
                {10, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid1, 0, 0);

        int[][] gameGridResult1 = {
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult1, gameGrid1);


        int[][] gameGrid2 = {
                {2, 1, 1, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {10, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid2, 2, 0);

        int[][] gameGridResult2 = {
                {2, 1, 1, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult2, gameGrid2);


        int[][] gameGrid3 = {
                {2, 1, 1, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {2, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {10, 1, 2, 1, 2, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid3, 5, 0);

        int[][] gameGridResult3 = {
                {2, 1, 1, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {2, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult3, gameGrid3);


        // Row 1 tests---------------------------------------------------------------------

        int[][] gameGrid4 = {
                {2, 10, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid4, 0, 1);

        int[][] gameGridResult4 = {
                {-1, -1, -1, 1, 2, 1},
                {-1, -1, -1, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult4, gameGrid4);


        int[][] gameGrid5 = {
                {2, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 10, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid5, 2, 1);

        int[][] gameGridResult5 = {
                {2, 1, 2, 1, 2, 1},
                {-1, -1, -1, 1, 2, 1},
                {-1, -1, -1, 2, 1, 2},
                {-1, -1, -1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult5, gameGrid5);


        int[][] gameGrid6 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 10, 2, 1, 2, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid6, 5, 1);

        int[][] gameGridResult6 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, -1, 1, 2, 1},
                {-1, -1, -1, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult6, gameGrid6);

    }

    @Test
    public void timeBombExplosionMiddleRowsTest () {

        // Row 2 tests---------------------------------------------------------------------

        int[][] gameGrid1 = {
                {2, 1, 10, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid1, 0, 2);

        int[][] gameGridResult1 = {
                {-1, -1, -1, 2, 2, 1},
                {-1, -1, -1, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult1, gameGrid1);


        int[][] gameGrid2 = {
                {2, 1, 1, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {1, 2, 10, 2, 1, 2},
                {2, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid2, 2, 2);

        int[][] gameGridResult2 = {
                {2, 1, 1, 1, 2, 1},
                {-1, -1, -1, 2, 2, 1},
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult2, gameGrid2);


        int[][] gameGrid3 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {2, 1, 2, 1, 2, 1},
                {2, 2, 10, 1, 2, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid3, 5, 2);

        int[][] gameGridResult3 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, -1, 2, 2, 1},
                {-1, -1, -1, 2, 2, 1},
        };
        assertArrayEquals(gameGridResult3, gameGrid3);


        // Row 3 tests---------------------------------------------------------------------

        int[][] gameGrid4 = {
                {2, 1, 2, 10, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid4, 0, 3);

        int[][] gameGridResult4 = {
                {-1, -1, -1, 2, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult4, gameGrid4);


        int[][] gameGrid5 = {
                {2, 1, 2, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 10, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid5, 3, 3);

        int[][] gameGridResult5 = {
                {2, 1, 2, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {-1, -1, -1, 1, 2, 2},
                {-1, -1, -1, 1, 2, 1},
                {-1, -1, -1, 1, 1, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult5, gameGrid5);


        int[][] gameGrid6 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 2, 10, 2, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid6, 5, 3);

        int[][] gameGridResult6 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult6, gameGrid6);


        // Row 4 tests---------------------------------------------------------------------

        int[][] gameGrid7 = {
                {-1, 1, 2, 1, 10, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid7, 0, 4);

        int[][] gameGridResult7 = {
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, 1, 1, 2},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult7, gameGrid7);


        int[][] gameGrid8 = {
                {2, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {-1, 1, 1, 2, 10, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid8, 2, 4);

        int[][] gameGridResult8 = {
                {2, 1, 2, 1, 2, 1},
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, -1, 1, 1},
                {-1, -1, -1, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult8, gameGrid8);


        int[][] gameGrid9 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {-1, 1, 2, 1, 10, 1},

        };
        TimeBomb.timeBombExplosion(gameGrid9, 5, 4);

        int[][] gameGridResult9 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, -1, 1, 2},
        };
        assertArrayEquals(gameGridResult9, gameGrid9);

    }

    @Test
    public void timeBombExplosionBottomRowTest () {

        int[][] gameGrid1 = {
                {-1, -1, 2, 1, 2, 10},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid1, 0, 5);

        int[][] gameGridResult1 = {
                {-1, -1, -1, -1, 2, 1},
                {-1, -1, -1, -1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult1, gameGrid1);


        int[][] gameGrid2 = {
                {2, 1, 1, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 1, 2, 1, 10},
                {-1, -1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid2, 3, 5);

        int[][] gameGridResult2 = {
                {2, 1, 1, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, -1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult2, gameGrid2);


        int[][] gameGrid3 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 10},
        };
        TimeBomb.timeBombExplosion(gameGrid3, 5, 5);

        int[][] gameGridResult3 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, -1, -1, 2, 1},
                {-1, -1, -1, -1, 2, 1},
        };
        assertArrayEquals(gameGridResult3, gameGrid3);



        int[][] gameGrid4 = {
                {-1, -1, 2, 1, 2, 10},
                {1, 2, 2, 1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid4, 0, 5);

        int[][] gameGridResult4 = {
                {-1, -1, -1, -1, 2, 1},
                {-1, -1, 1, 2, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult4, gameGrid4);


        int[][] gameGrid5 = {
                {2, 1, 1, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {2, 1, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 10},
                {1, 1, 2, 1, 2, 1},
        };
        TimeBomb.timeBombExplosion(gameGrid5, 4, 5);

        int[][] gameGridResult5 = {
                {2, 1, 1, 1, 2, 1},
                {2, 1, 2, 1, 2, 1},
                {-1, -1, 1, 2, 1, 2},
                {-1, -1, 2, 1, 1, 2},
                {-1, -1, -1, -1, 2, 1},
                {-1, -1,1, 1, 2, 1},
        };
        assertArrayEquals(gameGridResult5, gameGrid5);


        int[][] gameGrid6 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {2, 1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 10},
        };
        TimeBomb.timeBombExplosion(gameGrid6, 5, 5);

        int[][] gameGridResult6 = {
                {2, 2, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, -1, -1, 2, 1},
        };
        assertArrayEquals(gameGridResult6, gameGrid6);
    }

    @Test
    public void numberEmptySpacesInGridTest () {

        int[][] gameGrid1 = {
                {2, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1, 2},
                {1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertEquals(0, TimeBomb.numberEmptySpacesInGrid(gameGrid1));


        int[][] gameGrid2 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(36, TimeBomb.numberEmptySpacesInGrid(gameGrid2));


        int[][] gameGrid3 = {
                {-1, -1, 2, 1, 2, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1, 2, 1, 2, 1, 2},
                {-1, 2, 1, 2, 1, 1},
                {-1, -1, 2, 1, 2, 1},
                {-1,-1, 2, 1, 2, 1},
        };
        assertEquals(10, TimeBomb.numberEmptySpacesInGrid(gameGrid3));

        int[][] gameGrid4 = {
                {1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, 1, 2}
        };
        assertEquals(27, TimeBomb.numberEmptySpacesInGrid(gameGrid4));

        int[][] gameGrid5 = {
                {1, -1, -1, -1, -1, 1},
                {1, -1, -1, -1, -1, 1},
                {-1, -1, -1, 2, 1, 2},
                {-1, -1, -1, 2, 1, 2},
                {-1, -1, -1, 2, 1, 2},
                {-1, -1, -1, -1, 2, 2}
        };
        assertEquals(21, TimeBomb.numberEmptySpacesInGrid(gameGrid5));


        int[][] gameGrid6 = {
                {2, 1, 2, 1, 2, 1},
                {-1, 1, 2, 1, 2, 1},
                {-1, 2, 1, 2, 1, 2},
                {-1, 2, 1, 2, 1, 1},
                {1, 1, 2, 1, 2, 1},
                {1, 1, 2, 1, 2, 1},
        };
        assertEquals(3, TimeBomb.numberEmptySpacesInGrid(gameGrid6));
    }

}
