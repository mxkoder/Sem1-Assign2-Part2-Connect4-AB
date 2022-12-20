package GameTest;

import org.example.Game.GameGrid;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameGridTest {

    @Test
    void buildUnpopulatedStartColumnHeight6Test() {

        int [] column1 = GameGrid.buildUnpopulatedStartColumn(6);
        assertEquals(-1, column1[0]);
        assertEquals(-1, column1[1]);
        assertEquals(-1, column1[2]);
        assertEquals(-1, column1[3]);
        assertEquals(-1, column1[4]);
        assertEquals(-1, column1[5]);
    }

    @Test
    void buildUnpopulatedStartColumnUnusualHeightTest() {

        int [] column2 = GameGrid.buildUnpopulatedStartColumn(1);
        assertEquals(-1, column2[0]);

        int [] column4 = GameGrid.buildUnpopulatedStartColumn(10);
        assertEquals(-1, column4[0]);
        assertEquals(-1, column4[1]);
        assertEquals(-1, column4[3]);
        assertEquals(-1, column4[4]);
        assertEquals(-1, column4[8]);
        assertEquals(-1, column4[9]);
    }

    @Test
    void buildUnpopulatedStartColumnExceptionTest() {

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int [] column5 = GameGrid.buildUnpopulatedStartColumn(6);
            assertEquals(-1, column5[10]);
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int [] column6 = GameGrid.buildUnpopulatedStartColumn(6);
            assertEquals(-1, column6[-1]);
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int [] column7 = GameGrid.buildUnpopulatedStartColumn(6);
            assertEquals(-1, column7[100]);
        });
    }

    @Test
    void buildInitialGridTest() {

        int [][] grid1 = GameGrid.buildInitialGrid(6,6);

        assertEquals(-1, grid1[0][0]);
        assertEquals(-1, grid1[1][0]);
        assertEquals(-1, grid1[2][0]);
        assertEquals(-1, grid1[3][0]);
        assertEquals(-1, grid1[4][0]);
        assertEquals(-1, grid1[5][0]);

        assertEquals(-1, grid1[0][1]);
        assertEquals(-1, grid1[0][2]);
        assertEquals(-1, grid1[0][3]);
        assertEquals(-1, grid1[0][4]);
        assertEquals(-1, grid1[0][5]);

        assertEquals(-1, grid1[5][5]);

        assertEquals(-1, grid1[2][2]);
        assertEquals(-1, grid1[4][5]);
        assertEquals(-1, grid1[1][4]);
        assertEquals(-1, grid1[5][2]);
        assertEquals(-1, grid1[4][2]);
    }

    @Test
    void buildInitialGridExceptionTest() {

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int [][] grid2 = GameGrid.buildInitialGrid(6,6);
            assertEquals(-1, grid2[10][10]);
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int [][] grid3 = GameGrid.buildInitialGrid(6,6);
            assertEquals(-1, grid3[-2][-2]);
        });

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            int [][] grid3 = GameGrid.buildInitialGrid(6,6);
            assertEquals(-1, grid3[100][100]);
        });
    }

}
