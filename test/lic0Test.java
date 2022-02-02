import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class lic0Test {


    @Test
    void lic0_test_criteria_met_on_last_point() {
        Parameters test_params_zero = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points_zero = new Coordinate[5];
        points_zero[0] = new Coordinate(1, 0);
        points_zero[1] = new Coordinate(1, 0);
        points_zero[2] = new Coordinate(1, 0);
        points_zero[3] = new Coordinate(1, 0);
        points_zero[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points_zero, test_params_zero, new Connectors[5][5], new boolean[5][5]);

        assertTrue(decide.lic0());
    }

    @Test
    void lic0_test_distance_exactly_length1() {

        Parameters test_params_one = new Parameters(1.4142135623730951, 3.4, 4.0, 1.0,
                34, 12, 3.4, 5, 4, 3, 2, 1, 4, 3, 2,
                5, 2.03, 4.34, 3.4);

        Coordinate[] points_one = new Coordinate[3];
        points_one[0] = new Coordinate(0, 0);
        points_one[1] = new Coordinate(1, 1);
        points_one[2] = new Coordinate(1, 0);

        Decider decide = new Decider(3, points_one, test_params_one, new Connectors[3][3], new boolean[3][3]);

        assertFalse(decide.lic0());
    }

    @Test
    void lic0_test_length1_slighty_less_than_distance() {

        Parameters test_params_two = new Parameters(1.4142135623730950, 3.4, 4.0, 1.0,
                34, 12, 3.4, 5, 4, 3, 2, 1, 4, 3, 2,
                5, 2.03, 4.34, 3.4);

        Coordinate[] points_two = new Coordinate[3];
        points_two[0] = new Coordinate(0, 0);
        points_two[1] = new Coordinate(1, 1);
        points_two[2] = new Coordinate(1, 0);

        Decider decide = new Decider(3, points_two, test_params_two, new Connectors[3][3], new boolean[3][3]);

        assertTrue(decide.lic0());
    }

}
