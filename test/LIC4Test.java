import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC4Test {

    @Test
    void valid_points_true_test(){
        // Q_PTS = 3, QUADS = 2
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 3, 2, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(1, 1);   // Quad 1
        points[1] = new Coordinate(-1, 1);  // Quad 2
        points[2] = new Coordinate(-1, -1); // Quad 3

        Decider decider = new Decider(3, points, params, new Connectors[3][3], new boolean[3][3]);
        assertTrue(decider.lic4());
    }

    @Test
    void invalid_points_false_test(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 3, 2, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(1, 1);   // Quad 1
        points[1] = new Coordinate(-1, 1);  // Quad 2
        points[2] = new Coordinate(1, 2); // Quad 1

        Decider decider = new Decider(3, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic4());
    }

    @Test
    void not_consecutive_points_false_test(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 3, 2, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 1);   // Quad 1
        points[1] = new Coordinate(-1, 1);  // Quad 2
        points[2] = new Coordinate(1, 2); // Quad 1
        points[3] = new Coordinate(1, 3); // Quad 1
        points[4] = new Coordinate(-1, -2); // Quad 3

        Decider decider = new Decider(5, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic4());
    }

    @Test
    void points_on_borders_true_test(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 3, 2, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(0, 0);   // Quad 1
        points[1] = new Coordinate(-1, 0);  // Quad 2
        points[2] = new Coordinate(0, -1); // Quad 3

        Decider decider = new Decider(3, points, params, new Connectors[3][3], new boolean[3][3]);
        assertTrue(decider.lic4());
    }

    @Test
    void consecutive_not_beginning_true_test(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 3, 2, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(0, 0);   // Quad 1
        points[1] = new Coordinate(1, 1);   // Quad 1
        points[2] = new Coordinate(2, 2);   // Quad 1
        points[3] = new Coordinate(3, 3);   // Quad 1
        points[4] = new Coordinate(-1, 0);  // Quad 2
        points[5] = new Coordinate(0, -1); // Quad 3

        Decider decider = new Decider(6, points, params, new Connectors[3][3], new boolean[3][3]);
        assertTrue(decider.lic4());
    }

    @Test
    void invalid_qpts_false_test(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 1, 2, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[1];
        points[0] = new Coordinate(1, 1);   // Quad 1

        Decider decider = new Decider(1, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic4());
    }

    @Test
    void invalid_quads_false_test(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 3, 5, 1.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(1, 1);   // Quad 1
        points[1] = new Coordinate(1, -1);  // Quad 2
        points[2] = new Coordinate(-1, -1); // Quad 3


        Decider decider = new Decider(1, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic4());
    }
}
