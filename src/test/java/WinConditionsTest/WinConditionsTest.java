package WinConditionsTest;


import org.example.GameWin.WinConditions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinConditionsTest {

    @Test
    void horizontalRowOf4CheckNoWinTest () {

        int[][] gameGrid1 = {
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.horizontalRowOf4Check(gameGrid1));

        int[][] gameGrid2 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.horizontalRowOf4Check(gameGrid2));

        int[][] gameGrid3 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.horizontalRowOf4Check(gameGrid3));

        int[][] gameGrid4 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.horizontalRowOf4Check(gameGrid4));

        int[][] gameGrid5 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 2, 2, 2}
        };
        assertEquals(-1, WinConditions.horizontalRowOf4Check(gameGrid5));

        int[][] gameGrid6 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, 1, -1},
                {-1, -1, -1, 1, -1, -1},
                {-1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(-1, WinConditions.horizontalRowOf4Check(gameGrid6));

    }

    @Test
    void horizontalRowOf4CheckWinTest () {

        int[][] gameGrid7 = {
                {-1, -1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.horizontalRowOf4Check(gameGrid7));

        int[][] gameGrid8 = {
                {-1, -1, -1, 1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(2, WinConditions.horizontalRowOf4Check(gameGrid8));

        int[][] gameGrid9 = {
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, -1, 1, 1},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        assertEquals(1, WinConditions.horizontalRowOf4Check(gameGrid9));

        int[][] gameGrid10 = {
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, -1, 1, 2},
                {-1, -1, -1, 1, 2, 1},
                {-1, -1, -1, 1, 1, 2},
                {-1, -1, -1, 1, 1, 1},
                {-1, -1, -1, 1, 1, 1}
        };
        assertEquals(1, WinConditions.horizontalRowOf4Check(gameGrid10));
    }
}
