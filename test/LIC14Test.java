import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LIC14Test {

    @Test
    void same_points_both_criteria_true(){
        // AREA1: 0, AREA2: 2, E_PTS: 1, F_PTS: 1
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1.0, 1.0, 2.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(2, 0);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(-1, 1);
        points[4] = new Coordinate(0, 1);

        // Area is 1
        Decider decider = new Decider(5, points, params, new Connectors[15][15], new boolean[15][15], new boolean[15]);
        assertTrue(decider.lic14());
    }

    @Test
    void different_points_both_criteria_true(){
        // AREA1: 1, AREA2: 2, E_PTS: 1, F_PTS: 1
        Parameters params = new Parameters(0.0, 0.0, 0.0, 1.0, 0, 1, 1.0, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1.0, 1.0, 2.0);
        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(4, 0); // First criteria
        points[1] = new Coordinate(2, 0); // Second criteria
        points[2] = new Coordinate(0, 0); // First criteria
        points[3] = new Coordinate(0, 0); // Second criteria
        points[4] = new Coordinate(0, 1); // First criteria
        points[5] = new Coordinate(0, 1); // Second criteria

        // Area of points 0, 2, 4 is 2
        // Area of points 1, 3, 5 is 1
        Decider decider = new Decider(6, points, params, new Connectors[15][15], new boolean[15][15], new boolean[15]);
        assertTrue(decider.lic14());
    }

    @Test
    void not_enough_points_false(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1.0, 1.0, 2.0);
        Coordinate[] points = new Coordinate[4];
        points[0] = new Coordinate(2, 0);
        points[1] = new Coordinate(1, 0);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(0, 0);

        Decider decider = new Decider(4, points, params, new Connectors[15][15], new boolean[15][15], new boolean[15]);
        assertFalse(decider.lic14());
    }

    @Test
    void first_criteria_true_second_criteria_false_is_false(){
        // AREA1: 1, AREA2: 2, E_PTS: 1, F_PTS: 1
        Parameters params = new Parameters(0.0, 0.0, 0.0, 1.0, 0, 1, 1.0, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1.0, 1.0, 2.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(4, 0);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(-1, 1);
        points[4] = new Coordinate(0, 1);

        // Area is 2

        Decider decider = new Decider(4, points, params, new Connectors[15][15], new boolean[15][15], new boolean[15]);
        assertFalse(decider.lic14());
    }

    @Test
    void first_criteria_false_second_criteria_true_is_false(){
        // AREA1: 1, AREA2: 2, E_PTS: 1, F_PTS: 1
        Parameters params = new Parameters(0.0, 0.0, 0.0, 1.0, 0, 1, 1.0, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1.0, 1.0, 2.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(2, 0);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(-1, 1);
        points[4] = new Coordinate(0, 1);

        // Area is 1
        Decider decider = new Decider(4, points, params, new Connectors[15][15], new boolean[15][15], new boolean[15]);
        assertFalse(decider.lic14());
    }

    @Test
    void both_criteria_false_is_false(){
        // AREA1: 0, AREA2: 0, E_PTS: 1, F_PTS: 1
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1.0, 1.0, 0.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(0, 0);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(-1, 1);
        points[4] = new Coordinate(0, 0);

        // Area is 0
        Decider decider = new Decider(4, points, params, new Connectors[15][15], new boolean[15][15], new boolean[15]);
        assertFalse(decider.lic14());
    }
}
