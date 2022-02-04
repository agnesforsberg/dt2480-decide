import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeciderTest {

    private Connectors[][] setup_lcm(){
        /**
         * Sets up the LCM, Logical Connector Matrix, used for testing.
         *
         * @return A matrix containg NOTUSED, ANDD or ORR.
         */
        Connectors[][] lcm = new Connectors[15][15];
        for(int i = 0; i < lcm.length; i++){
            for(int j = 0; j < lcm[i].length; j++){
                lcm[i][j] = Connectors.NOTUSED;
            }
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                lcm[i][j] = Connectors.ANDD;
            }
        }
        lcm[2][0] = Connectors.ORR;
        lcm[2][1] = Connectors.ORR;
        lcm[0][2] = Connectors.ORR;
        lcm[1][2] = Connectors.ORR;
        lcm[1][3] = Connectors.ORR;
        lcm[3][1] = Connectors.ORR;


        return lcm;
    }

    private boolean[] setup_puv(){
        /**
         * Sets up the PUV used for testing, indicating which LIC to be considered as a factor.
         *
         * @return A list of booleans, true when the corresponding LIC should be considered otherwise false.
         */
        boolean[] puv = new boolean[15];
        for(int i = 0; i < puv.length; i++){
            puv[i] = true;
        }

        puv[1] = false;
        puv[3] = false;

        return puv;
    }

    @Test
    void decider_test_launch(){
        Connectors[][] lcm = setup_lcm();
        boolean[] puv = setup_puv();

        // Only length1, epsilon and area1 matters. Since only LIC0, LIC2 and LIC3 will be used (based on the puv and lcm).
        Parameters test_params = new Parameters(4, 1, 1.0, 3.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(0, 0);
        points[1] = new Coordinate(10, 0);
        points[2] = new Coordinate(8, 6);

        Decider decide = new Decider(3, points, test_params, lcm, new boolean[15][15], puv);

        assertTrue(decide.decide());
    }

    @Test
    void decider_test_launch_every_lic_met(){
        Connectors[][] lcm = new Connectors[15][15];
        boolean[] puv = new boolean[15];

        //Set up lcm
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                lcm[i][j] = Connectors.ANDD;
            }
        }

        //Set up puv
        for(int i = 0; i < 15; i++){
            puv[i] = true;
        }

        // All parameters matter since all LICs needs to be true.
        Parameters test_params = new Parameters(1, 1, 1.0, 3.0, 3, 2, 1,
                3, 1, 1, 1, 1, 1, 1, 1, 2, 10, 4.34, 10);

        Coordinate[] points = new Coordinate[6];
        points[0] = new Coordinate(0, 0);
        points[1] = new Coordinate(10, 10);
        points[2] = new Coordinate(1, 6);
        points[3] = new Coordinate(4, -3);
        points[4] = new Coordinate(2, 6);
        points[5] = new Coordinate(-4, 6);

        Decider decide = new Decider(6, points, test_params, lcm, new boolean[15][15], puv);

        assertTrue(decide.decide());
    }

    @Test
    void decider_test_not_launch_LIC0_not_met(){
        Connectors[][] lcm = setup_lcm();
        boolean[] puv = setup_puv();

        // Only length1, epsilon and area1 matters. Since only LIC0, LIC2 and LIC3 will be used (based on the puv and lcm).
        Parameters test_params = new Parameters(30, 1, 2.0, 3.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[3];
        points[0] = new Coordinate(0, 0);
        points[1] = new Coordinate(10, 0);
        points[2] = new Coordinate(8, 6);

        Decider decide = new Decider(3, points, test_params, lcm, new boolean[15][15], puv);

        assertFalse(decide.decide());
    }
}
