import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC11_Test {

    @Test
    void lic11_test_condition_met_early() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[8];
        test_points[0] = new Coordinate(5, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(4, 5);
        test_points[3] = new Coordinate(3, 2);
        test_points[4] = new Coordinate(7, 8);
        test_points[5] = new Coordinate(1, 1);
        test_points[6] = new Coordinate(6, 10);
        test_points[7] = new Coordinate(5, 1);

        Decider test_decider = new Decider(8, test_points, test_param, new Connectors[15][15], new boolean[15][15], new boolean[15]);

        assertTrue(test_decider.lic11());
    }

    @Test
    void lic11_test_condition_met_on_last_point() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[8];
        test_points[0] = new Coordinate(5, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(4, 5);
        test_points[3] = new Coordinate(3, 2);
        test_points[4] = new Coordinate(7, 8);
        test_points[5] = new Coordinate(5, 1);
        test_points[6] = new Coordinate(6, 10);
        test_points[7] = new Coordinate(1, 1);

        Decider test_decider = new Decider(8, test_points, test_param, new Connectors[8][8], new boolean[8][8], new boolean[15]);

        assertTrue(test_decider.lic11());
    }

    @Test
    void lic11_test_condition_not_met_less_than_three_points() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[2];
        test_points[0] = new Coordinate(5, 3);
        test_points[1] = new Coordinate(2, 2);

        Decider test_decider = new Decider(2, test_points, test_param, new Connectors[15][15], new boolean[15][15], new boolean[15]);

        assertFalse(test_decider.lic11());
    }

    @Test
    void lic11_test_condition_not_met() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[8];
        test_points[0] = new Coordinate(1, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(3, 5);
        test_points[3] = new Coordinate(4, 2);
        test_points[4] = new Coordinate(5, 8);
        test_points[5] = new Coordinate(6, 1);
        test_points[6] = new Coordinate(7, 10);
        test_points[7] = new Coordinate(8, 1);

        Decider test_decider = new Decider(8, test_points, test_param, new Connectors[15][15], new boolean[15][15], new boolean[15]);

        assertFalse(test_decider.lic11());
    }
}