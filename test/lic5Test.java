import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lic5Test {

    @Test
    void lic5_test0() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(1, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(4, 5);
        test_points[3] = new Coordinate(3, 1);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[4][4],new boolean[4][4]);

        assertTrue(test_decider.lic5());
    }

    @Test
    void lic5_test1() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(1, 3);
        test_points[1] = new Coordinate(0, 2);
        test_points[2] = new Coordinate(1, 5);
        test_points[3] = new Coordinate(5, 1);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[4][4],new boolean[4][4]);

        assertTrue(test_decider.lic5());
    }

    @Test
    void lic5_test2() {
        Parameters test_param = new Parameters(2.0,3.0,3.0,1.0,1,2,3.0,
                4, 4, 6, 7,4,5,6,5,4,3.0,2.0,3.0);

        Coordinate[] test_points = new Coordinate[4];
        test_points[0] = new Coordinate(1, 3);
        test_points[1] = new Coordinate(2, 2);
        test_points[2] = new Coordinate(2, 5);
        test_points[3] = new Coordinate(5, 1);

        Decider test_decider = new Decider(4, test_points, test_param, new Connectors[4][4],new boolean[4][4]);

        assertFalse(test_decider.lic5());
    }

}

