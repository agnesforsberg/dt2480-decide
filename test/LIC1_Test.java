import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC1_Test {

    @Test
    void lic1_test_condition_met_early(){
        Parameters test_param = new Parameters(2.0,3.0,2.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(10, 10);
        test_points[1] = new Coordinate(1, 1);
        test_points[2] = new Coordinate(3, 1);
        test_points[3] = new Coordinate(2, 1);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[4][4], new boolean[4][4]);

        assertTrue(test_decider.lic1());
    }

    @Test
    void lic1_test_condition_met_on_last_point(){
        Parameters test_param = new Parameters(2.0,3.0,2.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(1, 3);
        test_points[1] = new Coordinate(1, 1);
        test_points[2] = new Coordinate(3, 1);
        test_points[3] = new Coordinate(10, 10);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[4][4], new boolean[4][4]);

        assertTrue(test_decider.lic1());
    }

    @Test
    void lic1_test_condition_not_met_all_points_in_circle(){
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(1, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(3, 1);
        test_points[3] = new Coordinate(2, 1);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[4][4], new boolean[4][4]);

        assertFalse(test_decider.lic1());
    }

    @Test
    void lic1_test_condition_not_met_some_points_on_circle(){
        Parameters test_param = new Parameters(2.0,1.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[3];
        test_points[0] = new Coordinate(0, 1);
        test_points[1] = new Coordinate(1, 1);
        test_points[2] = new Coordinate(2, 1);

        Decider test_decider = new Decider(3, test_points, test_param, new Connectors[3][3], new boolean[3][3]);

        assertFalse(test_decider.lic1());
    }


}