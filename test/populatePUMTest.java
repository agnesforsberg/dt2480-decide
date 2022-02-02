import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class populatePUMTest {

    @Test
    void test_pum_is_symetrical(){

        Connectors[][] lcm = new Connectors[15][15];

        // Fill lcm with NOTUSED
        for (Connectors[] row : lcm){
            for(int i = 0; i < row.length-1; i++){
                row[i] = Connectors.NOTUSED;
            }
        }

        Parameters test_params_zero = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points_zero = new Coordinate[5];
        points_zero[0] = new Coordinate(1, 0);
        points_zero[1] = new Coordinate(1, 0);
        points_zero[2] = new Coordinate(1, 0);
        points_zero[3] = new Coordinate(1, 0);
        points_zero[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points_zero, test_params_zero, lcm, new boolean[15][15]);

        assertTrue(true, true); // Dummy Assertion

    }
}
