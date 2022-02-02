import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC8_Test {
    @Test
	@Test
	void testLIC13_0() {
        //example that does not work because of first condition
        Parameters p = new Parameters(0, 5, 0, 10, 0, 0, 0,
                0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 0);

        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(2, 2);
        points[2] = new Coordinate(1, 2);
        points[3] = new Coordinate(1, 3);
        points[4] = new Coordinate(2, 3);
        points[5] = new Coordinate(3, 3);

        Decider decide = new Decider(6, points, p, new Connectors[6][6], new boolean[6][6]);

        assertFalse(decide.lic13());
    }
    void testLIC13_1() {
        //example that does work because of 2nd condition 
        Parameters p = new Parameters(0, 5, 0, 10, 0, 0, 0,
                0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 0);

        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(2, 2);
        points[2] = new Coordinate(1, 2);
        points[3] = new Coordinate(1, 3);
        points[4] = new Coordinate(2, 40);
        points[5] = new Coordinate(3, 40);

        Decider decide = new Decider(6, points, p, new Connectors[6][6], new boolean[6][6]);

        assertFalse(decide.lic13());
    }

    void testLIC13_2() {
        //example that does work
        Parameters p = new Parameters(0, 5, 0, 10, 0, 0, 0,
                0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 0);

        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(0, 0);
        points[1] = new Coordinate(2, 2);
        points[2] = new Coordinate(20, 0);
        points[3] = new Coordinate(1, 3);
        points[4] = new Coordinate(10, 20);
        points[5] = new Coordinate(3, 3);

        Decider decide = new Decider(6, points, p, new Connectors[6][6], new boolean[6][6]);

        assertTrue(decide.lic13());
    }

    
}