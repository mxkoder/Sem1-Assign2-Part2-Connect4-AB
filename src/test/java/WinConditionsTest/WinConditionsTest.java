package WinConditionsTest;


import org.example.GameWin.WinConditions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinConditionsTest {

    // -----------------------------------------Row of 4 Tests----------------------------------------------
    @Test
    void rowOf4CheckNoWinTest () {

        int[][] gameGrid1 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.rowOf4Check(gameGrid1));

        int[][] gameGrid2 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.rowOf4Check(gameGrid2));

        int[][] gameGrid3 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.rowOf4Check(gameGrid3));

        int[][] gameGrid4 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.rowOf4Check(gameGrid4));

        int[][] gameGrid5 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 2, 2, 2}
        };
        assertEquals(-1, WinConditions.rowOf4Check(gameGrid5));

        int[][] gameGrid6 = {
                {1, 1, 2, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 1, -1, 1, 1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 2, 1, 1, 1}
        };
        assertEquals(-1, WinConditions.rowOf4Check(gameGrid6));

    }

    @Test
    void rowOf4CheckWinTest () {

        int[][] gameGrid7 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.rowOf4Check(gameGrid7));

        int[][] gameGrid8 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.rowOf4Check(gameGrid8));

        int[][] gameGrid9 = {
                {-1, -1, -1, 1, 1, 2},
                {-1, 1, -1, -1, 1, 2},
                {-1, 1, -1, -1, -1, 1},
                {-1, 1, -1, -1, 1, 2},
                {-1, 1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.rowOf4Check(gameGrid9));

        int[][] gameGrid10 = {
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, 1, 2, 1},
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1}
        };
        assertEquals(1, WinConditions.rowOf4Check(gameGrid10));

    }

    // -----------------------------------------Column of 4 Tests----------------------------------------------
    @Test
    void columnOf4CheckNoWinTest () {

        int[][] gameGrid11 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.columnOf4Check(gameGrid11));

        int[][] gameGrid12 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1}
        };
        assertEquals(-1, WinConditions.columnOf4Check(gameGrid12));

        int[][] gameGrid13 = {
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.columnOf4Check(gameGrid13));

        int[][] gameGrid14 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.columnOf4Check(gameGrid14));

        int[][] gameGrid15 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, 2, 1, 2, 2}
        };
        assertEquals(-1, WinConditions.columnOf4Check(gameGrid15));

        int[][] gameGrid16 = {
                {1, 1, -1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.columnOf4Check(gameGrid16));
    }


    @Test
    void columnOf4CheckWinTest () {

        int[][] gameGrid17 = {
                {-1, -1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.columnOf4Check(gameGrid17));

        int[][] gameGrid18 = {
                {-1, -1, 2,2, 2, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.columnOf4Check(gameGrid18));

        int[][] gameGrid19 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 2, 2, 2, 2, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.columnOf4Check(gameGrid19));

        int[][] gameGrid20 = {
                {-1, -1, -1, 1, -1, -1},
                {1, 1, -1, 1, 2, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 2, 2},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.columnOf4Check(gameGrid20));
    }


    // -----------------------------------------Diagonal of 4 Tests----------------------------------------------
    @Test
    void diagonalOf4CheckNoWinTest () {

        int[][] gameGrid21 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid21));

        int[][] gameGrid22 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, 1, -1, -1, -1, -1},
                {1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid22));

        int[][] gameGrid23 = {
                {-1, -1, -1, 1, 1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 2, -1, -1, -1},
                {-1, 1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid23));

        int[][] gameGrid24 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid24));

        int[][] gameGrid25 = {
                {1, -1, -1, 1, -1, -1},
                {-1, 1, -1, -1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid25));

        int[][] gameGrid26 = {
                {-1, 1, 1, 1, 2, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, -1, -1, -1, -1, -1},
                {-1, 2, -1, -1, -1, -1},
                {-1, -1, 2, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid26));

        int[][] gameGrid27 = {
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, 1, 2, 2, 2},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, 1, -1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid27));

        int[][] gameGrid28 = {
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1}
        };
        assertEquals(-1, WinConditions.diagonalOf4Check(gameGrid28));

    }


    @Test
    void diagonalOf4CheckWinTest () {

        int[][] gameGrid29 = {
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.diagonalOf4Check(gameGrid29));

        int[][] gameGrid30 = {
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, 2, -1},
                {-1, -1, -1, 2, -1, -1},
                {-1, -1, 2, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.diagonalOf4Check(gameGrid30));

        int[][] gameGrid31 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, -1, -1, 1}
        };
        assertEquals(1, WinConditions.diagonalOf4Check(gameGrid31));

        int[][] gameGrid32 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, 2, -1, -1, -1},
                {-1, -1, -1, 2, -1, -1},
                {-1, -1, -1, -1, 2, -1},
                {-1, -1, -1, -1, -1, 2}
        };
        assertEquals(2, WinConditions.diagonalOf4Check(gameGrid32));

        int[][] gameGrid33 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, 1, -1, -1, -1, -1},
                {1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.diagonalOf4Check(gameGrid33));

        int[][] gameGrid34 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 2, -1},
                {-1, -1, -1, 2, -1, -1},
                {-1, -1, 2, -1, -1, -1},
                {-1, 2, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.diagonalOf4Check(gameGrid34));

        int[][] gameGrid35 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 1, -1, -1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, 1, -1}
        };
        assertEquals(1, WinConditions.diagonalOf4Check(gameGrid35));

        int[][] gameGrid36 = {
                {-1, -1, 2, -1, -1, -1},
                {-1, -1, -1, 2, -1, -1},
                {-1, -1, -1, -1, 2, -1},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.diagonalOf4Check(gameGrid36));

        int[][] gameGrid37 = {
                {-1, -1, -1, -1, 1, 1},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, 1, 2, 2, 2},
                {-1, 1, 2, 2, 1, 2},
                {2, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.diagonalOf4Check(gameGrid37));

        int[][] gameGrid38 = {
                {-1, -1, -1, -1, -1, 2},
                {1, -1, -1, -1, -1, 2},
                {-1, 1, 2, 1, 1, 2},
                {-1, -1, 1, 2, 2, 1},
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, -1, -1, 2}
        };
        assertEquals(1, WinConditions.diagonalOf4Check(gameGrid38));


    }

}
