import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC6_Test {

    @Test
    void lic6_test_condition_met_early_line() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[6];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(1, 10);
        test_points[2] = new Coordinate(0, 0);
        test_points[3] = new Coordinate(3, 1);
        test_points[4] = new Coordinate(0, 0);
        test_points[5] = new Coordinate(0, 0);

        Decider test_decider = new Decider(6, test_points, test_param, new Connectors[6][6],new boolean[6][6]);

        assertTrue(test_decider.lic6());
    }

    @Test
    void lic6_test_condition_met_last_point_line() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[6];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(0, 0);
        test_points[2] = new Coordinate(0, 1);
        test_points[3] = new Coordinate(3, 1);
        test_points[4] = new Coordinate(1, 10);
        test_points[5] = new Coordinate(3, 1);

        Decider test_decider = new Decider(6, test_points, test_param, new Connectors[6][6],new boolean[6][6]);

        assertTrue(test_decider.lic6());
    }

    @Test
    void lic6_test_condition_met_early_same_start_and_end_point() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[6];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(0, -10);
        test_points[2] = new Coordinate(0, 2);
        test_points[3] = new Coordinate(0, 1);
        test_points[4] = new Coordinate(1, 2);
        test_points[5] = new Coordinate(3, 1);

        Decider test_decider = new Decider(6, test_points, test_param, new Connectors[6][6],new boolean[6][6]);

        assertTrue(test_decider.lic6());
    }

    @Test
    void lic6_test_condition_met_last_point_same_start_and_end_point() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[6];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(1, 2);
        test_points[2] = new Coordinate(0, 2);
        test_points[3] = new Coordinate(0, 1);
        test_points[4] = new Coordinate(0, 11);
        test_points[5] = new Coordinate(0, 2);

        Decider test_decider = new Decider(6, test_points, test_param, new Connectors[6][6],new boolean[6][6]);

        assertTrue(test_decider.lic6());
    }

    @Test
    void lic6_test_condition_not_met_less_than_three_points(){
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                3, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[2];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(1, 10);

        Decider test_decider = new Decider(2, test_points, test_param, new Connectors[2][2],new boolean[2][2]);

        assertFalse(test_decider.lic6());
    }

    @Test
    void lic6_test_condition_not_met_line() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[6];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(1, 6);
        test_points[2] = new Coordinate(0, 0);
        test_points[3] = new Coordinate(3, 1);
        test_points[4] = new Coordinate(0, 0);
        test_points[5] = new Coordinate(0, 0);

        Decider test_decider = new Decider(6, test_points, test_param, new Connectors[6][6],new boolean[6][6]);

        assertFalse(test_decider.lic6());
    }

    @Test
    void lic6_test_condition_not_met_same_start_and_end_point() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,8.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[6];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(1, 6);
        test_points[2] = new Coordinate(0, 0);
        test_points[3] = new Coordinate(0, 1);
        test_points[4] = new Coordinate(0, 3);
        test_points[5] = new Coordinate(0, 0);

        Decider test_decider = new Decider(6, test_points, test_param, new Connectors[6][6],new boolean[6][6]);

        assertFalse(test_decider.lic6());
    }
}