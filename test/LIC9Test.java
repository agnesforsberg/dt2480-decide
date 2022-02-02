import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LIC9Test {

    @Test
    void not_enough_points_fails(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(-1, -1);

        Decider decider = new Decider(3, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic9());
    }

    @Test
    void too_big_CPTS_and_DPTS_fails(){
        // C_PTS 1, D_PTS 3
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                1, 3, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(-1, -1);
        points[3] = new Coordinate(0, 0);
        points[4] = new Coordinate(5, 5);

        Decider decider = new Decider(5, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic9());
    }

    @Test
    void equal_points_fails(){
        Parameters params = new Parameters(0.0, 0.0, 0.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 1);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(1, 1); // Same as points[0]
        points[3] = new Coordinate(0, 0);
        points[4] = new Coordinate(5, 5);

        Decider decider = new Decider(5, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic9());
    }

    @Test
    void basic_valid_case_true(){
        // C_PTS 1, D_PTS 1, epsilon 1
        Parameters params = new Parameters(0.0, 0.0, 1.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(0, 1);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(0, 0);
        points[4] = new Coordinate(1, 0);

        // Angle is PI/2, which is < PI-1

        Decider decider = new Decider(5, points, params, new Connectors[3][3], new boolean[3][3]);
        assertTrue(decider.lic9());
    }

    @Test
    void valid_angle_wrong_points_distance_fails(){
        // C_PTS 1, D_PTS 1, epsilon 1
        Parameters params = new Parameters(0.0, 0.0, 1.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(0, 1);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(0, 0);
        points[4] = new Coordinate(0, -1); // Not valid angle here
        points[5] = new Coordinate(1, 0); // Valid angle here, but D_PTS too small

        // Angle is PI/2, which is < PI-1

        Decider decider = new Decider(6, points, params, new Connectors[3][3], new boolean[3][3]);
        assertFalse(decider.lic9());
    }

    @Test
    void valid_angle_longer_distance_true(){
        // C_PTS 3, D_PTS 2, epsilon 1
        Parameters params = new Parameters(0.0, 0.0, 1.0, 0.0, 0, 1, 1.0, 1, 1, 1, 1,
                3, 2, 1, 1, 1, 1.0, 1.0, 1.0);
        Coordinate[] points = new Coordinate[8];
        points[0] = new Coordinate(0, 1);
        points[1] = new Coordinate(-1, 1);
        points[2] = new Coordinate(0, 0);
        points[3] = new Coordinate(0, 0);
        points[4] = new Coordinate(0, 0);
        points[5] = new Coordinate(1, 0);
        points[6] = new Coordinate(1, 0);
        points[7] = new Coordinate(1, 0);

        // Angle is PI/2, which is < PI-1

        Decider decider = new Decider(8, points, params, new Connectors[3][3], new boolean[3][3]);
        assertTrue(decider.lic9());
    }
}
