package SpecialMoveTest;

import org.example.GameEnd.GameWin;
import org.example.SpecialMoves.Blitz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BlitzTest {

    @Test
    public void blitzMoveMechanicsTest () {

        int [] emptyColumn = {-1, -1, -1, -1, -1, -1};


        int[][] gameGrid1 = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        Blitz.blitzMoveMechanics(gameGrid1, 0);
        assertArrayEquals(emptyColumn, gameGrid1[0]);

        Blitz.blitzMoveMechanics(gameGrid1, 3);
        assertArrayEquals(emptyColumn, gameGrid1[3]);

        Blitz.blitzMoveMechanics(gameGrid1, 5);
        assertArrayEquals(emptyColumn, gameGrid1[5]);


        int[][] gameGrid2 = {
                {1, 1, 2, 2, 1, 2},
                {1, 2, 1, 1, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 2, 1, 2, 2, 1},
                {1, 1, 2, 1, 1, 2},
                {1, 2, 1, 2, 1, 2}
        };

        Blitz.blitzMoveMechanics(gameGrid2, 0);
        assertArrayEquals(emptyColumn, gameGrid2[0]);

        Blitz.blitzMoveMechanics(gameGrid2, 1);
        assertArrayEquals(emptyColumn, gameGrid2[1]);

        Blitz.blitzMoveMechanics(gameGrid2, 2);
        assertArrayEquals(emptyColumn, gameGrid2[2]);


        int[][] gameGrid3 = {
                {1, 1, 1, 2, 1, 2},
                {1, 2, 2, 2, 1, 2},
                {2, 1, 2, 2, 1, 2},
                {2, 2, 1, 1, 2, 1},
                {1, 1, 1, 2, 2, 1},
                {1, 2, 1, 2, 1, 2}
        };
        Blitz.blitzMoveMechanics(gameGrid3, 0);
        assertArrayEquals(emptyColumn, gameGrid3[0]);

        Blitz.blitzMoveMechanics(gameGrid3, 2);
        assertArrayEquals(emptyColumn, gameGrid3[2]);

        Blitz.blitzMoveMechanics(gameGrid3, 4);
        assertArrayEquals(emptyColumn, gameGrid3[4]);

        int[][] gameGrid4 = {
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1}
        };

        Blitz.blitzMoveMechanics(gameGrid4, 0);
        assertArrayEquals(emptyColumn, gameGrid4[0]);

        Blitz.blitzMoveMechanics(gameGrid4, 3);
        assertArrayEquals(emptyColumn, gameGrid4[3]);

        Blitz.blitzMoveMechanics(gameGrid4, 5);
        assertArrayEquals(emptyColumn, gameGrid4[5]);


        int[][] gameGrid5 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };

        Blitz.blitzMoveMechanics(gameGrid5, 0);
        assertArrayEquals(emptyColumn, gameGrid5[0]);

        Blitz.blitzMoveMechanics(gameGrid5, 1);
        assertArrayEquals(emptyColumn, gameGrid5[1]);

        Blitz.blitzMoveMechanics(gameGrid5, 4);
        assertArrayEquals(emptyColumn, gameGrid5[4]);


    }
}
