package GameEndTest;

import org.example.GameEnd.Draw;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawTest {

    @Test
    void gameIsADrawTest () {

        int[][] gameGrid1 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        assertEquals(false, Draw.gameIsADraw(gameGrid1));


        int[][] gameGrid2 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(false, Draw.gameIsADraw(gameGrid2));


        int[][] gameGrid3 = {
                {1, 1, 2, 2, 1, 2},
                {1, 2, 1, 1, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 2, 1, 2, 2, 1},
                {1, 1, 2, 1, 1, 2},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(true, Draw.gameIsADraw(gameGrid3));

        int[][] gameGrid4 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(true, Draw.gameIsADraw(gameGrid4));
    }

    @Test
    void gridIsFilled_FullGrid_Test () {

        int[][] gameGrid1 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        assertEquals(true, Draw.gridIsFilled(gameGrid1));

        int[][] gameGrid2 = {
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2}
        };
        assertEquals(true, Draw.gridIsFilled(gameGrid2));

        int[][] gameGrid3 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 2, 1, 2, 2, 1},
                {1, 1, 2, 2, 1, 2},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(true, Draw.gridIsFilled(gameGrid3));

        int[][] gameGrid4 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 2, 1, 2, 2, 1},
                {1, 1, 2, 2, 1, 2},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(true, Draw.gridIsFilled(gameGrid4));

        int[][] gameGrid5 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(true, Draw.gridIsFilled(gameGrid5));

    }

    @Test
    void gridIsFilled_Empty_GridTest () {

        int[][] gameGrid1 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid1));
    }

    @Test
    void gridIsFilled_partiallyEmpty_GridTest () {

        int[][] gameGrid1 = {
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid1));

        int[][] gameGrid2 = {
                {-1, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid2));

        int[][] gameGrid3 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {-1, 2, 1, 2, 1, 2}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid3));

        int[][] gameGrid4 = {
                {-1, 1, 1, 2, 1, 2},
                {1, 2, 2, 1, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {-1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid4));

        int[][] gameGrid5 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid5));

        int[][] gameGrid6 = {
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(false, Draw.gridIsFilled(gameGrid6));


    }
}
