import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC3_Test {

    @Test
	void testLIC3_0() {
        //example that does not work
        Parameters p = new Parameters(0, 0, 0, 10, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(2, 2);
        points[2] = new Coordinate(1, 2);
        points[3] = new Coordinate(1, 3);
        points[4] = new Coordinate(2, 3);

        Decider decide = new Decider(5, points, p, new Connectors[5][5], new boolean[5][5], new boolean[5]);

        assertFalse(decide.lic3());
    }

    @Test
	void testLIC2_1() {//Example that works 
        Parameters test_params = new Parameters(0, 0, 0, 10, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(1, 2);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(20, 0);
        points[4] = new Coordinate(0, 20);

        Decider decide = new Decider(5, points, test_params, new Connectors[5][5], new boolean[5][5], new boolean[5]);


        assertTrue(decide.lic3());
    }

    
} 