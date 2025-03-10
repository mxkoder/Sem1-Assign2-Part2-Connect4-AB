package TurnTest;

import org.example.Turn.TurnMechanism;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnMechanismTest {

    @Test
    void getTopColumnEmptyIndexTest() {

        int [] column1 = {-1, -1, -1, -1, -1, -1};
        assertEquals(5, TurnMechanism.getTopColumnEmptyIndex(column1));

        int [] column4 = {-1, -1, 1, 2, 1, 1};
        assertEquals(1, TurnMechanism.getTopColumnEmptyIndex(column4));

        int [] column5 = {-1, -1, -1, -1, 1, 1};
        assertEquals(3, TurnMechanism.getTopColumnEmptyIndex(column5));

        int [] column6 = {-1, -1, -1, -1, -1, 1};
        assertEquals(4, TurnMechanism.getTopColumnEmptyIndex(column6));
    }

    @Test
    void getTopColumnEmptyIndexFullColumnTest() {

        int [] column2 = {2, 2, 2, 1, 1, 1};
        assertEquals(-1, TurnMechanism.getTopColumnEmptyIndex(column2));

        int [] column3 = {1, 1, 1, 2, 2, 2};
        assertEquals(-1, TurnMechanism.getTopColumnEmptyIndex(column3));

    }

    @Test
    void takeTurnDropCounterTest() {

        int[] column7 = {-1, -1, -1, -1, -1, -1};
        assertEquals(true, TurnMechanism.takeTurnDropCounter(1, column7));

        int[] column8 = {-1, -1, 1, 1, 1, 1};
        assertEquals(true, TurnMechanism.takeTurnDropCounter(1, column8));

        int[] column9 = {-1, -1, -1, -1, -1, 2};
        assertEquals(true, TurnMechanism.takeTurnDropCounter(1, column9));

        int[] column10 = {-1, 10, 1, 1, 1, 1};
        assertEquals(true, TurnMechanism.takeTurnDropCounter(1, column10));
    }

    @Test
    void takeTurnDropCounterFullColumnTest() {

        int[] column11 = {1, 1, 1, 1, 1, 1};
        assertEquals(false, TurnMechanism.takeTurnDropCounter(1, column11));

        int[] column12 = {2, 2, 2, 2, 2, 2};
        assertEquals(false, TurnMechanism.takeTurnDropCounter(1, column12));

        int[] column13 = {1, 2, 1, 2, 2, 2};
        assertEquals(false, TurnMechanism.takeTurnDropCounter(1, column13));

        int[] column14 = {10, 2, 1, 2, 2, 2};
        assertEquals(false, TurnMechanism.takeTurnDropCounter(1, column14));
    }

    @Test
    void takeTurnDropCounterChangeInColumnTest() {

        int[] column15 = {-1, -1, -1, -1, -1, -1};
        TurnMechanism.takeTurnDropCounter(1, column15);
        assertEquals(1, column15[5]);
        assertEquals(-1, column15[4]);
        assertEquals(-1, column15[3]);

        int[] column16 = {-1, -1, 1, 1, 1, 1};
        TurnMechanism.takeTurnDropCounter(1, column16);
        assertEquals(1, column16[2]);
        assertEquals(1, column16[1]);
        assertEquals(-1, column16[0]);

        int[] column17 = {-1, -1, -1, -1, -1, 1};
        TurnMechanism.takeTurnDropCounter(2, column17);
        assertEquals(1, column17[5]);
        assertEquals(2, column17[4]);
        assertEquals(-1, column17[3]);

        int[] column18 = {-1, 10, 1, 1, 1, 1};
        TurnMechanism.takeTurnDropCounter(2, column18);
        assertEquals(1, column18[2]);
        assertEquals(10, column18[1]);
        assertEquals(2, column18[0]);
    }
}
