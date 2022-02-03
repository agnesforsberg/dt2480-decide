import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lic10Test {

    @Test
    void lic10_test_size_under_five() {
        //Lic10 should automatically fail when numpoints < 5.

        Parameters test_param = new Parameters(2.0,3.0,3.0,2.0,1,2,3.0,
                4, 4, 6, 7,4,5,1,2,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(13, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(4, 55);
        test_points[2] = new Coordinate(4, 53);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[15][15],new boolean[15][15], new boolean[15]);

        assertFalse(test_decider.lic10());
    }

    @Test
    void lic10_test_exactly_equal_to_area1() {
        //Lic10 should fail even when the largest triangle area is equal to area1,
        // it needs to be greater than area1 to pass.

        // Due to rounding errors in doubles there may be cases where the result may be wrong
        // with a rounding error of approximately 0.000000000000003

        Parameters test_param = new Parameters(2.0,3.0,3.0,2.0,1,2,3.0,
                4, 4, 6, 7,4,5,1,2,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[7];
        test_points[0] = new Coordinate(0, 0);
        test_points[1] = new Coordinate(0, 0);
        test_points[2] = new Coordinate(0, 0);
        test_points[3] = new Coordinate(2, 0);
        test_points[4] = new Coordinate(0, 0);
        test_points[5] = new Coordinate(0, 0);
        test_points[6] = new Coordinate(2, 2);

        Decider test_decider = new Decider(7, test_points, test_param, new Connectors[15][15], new boolean[15][15], new boolean[15]);

        assertFalse(test_decider.lic10());
    }

    @Test
    void lic10_test_condition_met_at_last_point() {
        // Checking That it loops to check the last point before breaking the loop.
        // Condition is met on last possible set of points in points[] array.

        Parameters test_param = new Parameters(2.0,3.0,3.0,2.0,1,2,3.0,
                4, 4, 6, 7,4,5,1,2,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[8];
        test_points[0] = new Coordinate(0, 0);
        test_points[1] = new Coordinate(0, 0);
        test_points[2] = new Coordinate(0, 0);
        test_points[3] = new Coordinate(0, 0);
        test_points[4] = new Coordinate(4, 0);
        test_points[5] = new Coordinate(0, 0);
        test_points[6] = new Coordinate(0, 0);
        test_points[7] = new Coordinate(4, 4);

        Decider test_decider = new Decider(8, test_points, test_param, new Connectors[15][15], new boolean[15][15], new boolean[15]);

        assertTrue(test_decider.lic10());
    }

    @Test
    void lic10_test_e_f_too_large_for_points() {
        // Checking That the method returns false if the following statement is not true (E PTS+F PTS ≤ NUMPOINTS−3).

        Parameters test_param = new Parameters(2.0,3.0,3.0,2.0,1,2,3.0,
                4, 4, 6, 7,4,5,1,2,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[5];

        test_points[0] = new Coordinate(0, 0);
        test_points[1] = new Coordinate(2, 0);
        test_points[2] = new Coordinate(0, 0);
        test_points[3] = new Coordinate(0, 0);
        test_points[4] = new Coordinate(2, 3);

        Decider test_decider = new Decider(5, test_points, test_param, new Connectors[15][15], new boolean[15][15], new boolean[15]);

        assertFalse(test_decider.lic10());
    }


}