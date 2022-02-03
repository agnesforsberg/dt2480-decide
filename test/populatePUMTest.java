import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class populatePUMTest {

    @Test
    void test_pum_is_symetrical(){

        Connectors[][] lcm = new Connectors[15][15];

        // Fill lcm with NOTUSED
        for (Connectors[] row : lcm){
            for(int i = 0; i < row.length; i++){
                row[i] = Connectors.NOTUSED;
            }
        }
        //Set LCM[0,6] and LCM[6,0] to ORR
        lcm[0][6] = Connectors.ORR;
        lcm[6][0] = Connectors.ORR;

        Parameters test_params = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5]; // These Coords together with test params will result in lic0 as true
        points[0] = new Coordinate(1, 0);
        points[1] = new Coordinate(1, 0);
        points[2] = new Coordinate(1, 0);
        points[3] = new Coordinate(1, 0);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, lcm, new boolean[15][15], new boolean[15]);
        decide.populateCMV();
        decide.populatePUM();
        boolean[][] test_pum = decide.getPum();

        boolean symmetry = true;
        for(int i = 0; i <= 14; i++){ // Loop through all values of test_pum
            for(int j = 0; j <= 14; j++){
                symmetry = ((test_pum[i][j] == test_pum[j][i]) && symmetry); // Set to false if one case is false
            }
        }
        assertTrue(symmetry);
    }

    @Test
    void test_pum_orr_works(){
        //Test if PUM turns true if one of the LICs that are related trhough an ORR is true.

        Connectors[][] lcm = new Connectors[15][15];

        // Fill lcm with NOTUSED
        for (Connectors[] row : lcm){
            for(int i = 0; i < row.length; i++){
                row[i] = Connectors.NOTUSED;
            }
        }
        //Set LCM[0,6] and LCM[6,0] to ORR
        lcm[0][6] = Connectors.ORR;
        lcm[6][0] = Connectors.ORR;

        Parameters test_params = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5]; // These Coords together with test params will result in lic0 as true
        points[0] = new Coordinate(1, 0);
        points[1] = new Coordinate(1, 0);
        points[2] = new Coordinate(1, 0);
        points[3] = new Coordinate(1, 0);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, lcm, new boolean[15][15], new boolean[15]);
        decide.populateCMV();
        decide.populatePUM();
        boolean[][] test_pum = decide.getPum();

        boolean lic0 = decide.lic0();
        boolean lic6 = decide.lic6();

        assertTrue((lic0 != lic6) && decide.getPum()[0][6]); //Check if only one of them is true and if PUM is true

    }

    @Test
    void test_pum_andd_works(){
        // Test if PUM turns true if both lics related through an ANDD is true

        Connectors[][] lcm = new Connectors[15][15];

        // Fill lcm with NOTUSED
        for (Connectors[] row : lcm){
            for(int i = 0; i < row.length; i++){
                row[i] = Connectors.NOTUSED;
            }
        }
        //Set LCM[0,5] and LCM[5,0] to ANDD
        lcm[0][5] = Connectors.ANDD;
        lcm[5][0] = Connectors.ANDD;

        Parameters test_params = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5]; // These Coords together with test params will result in lic0 as true
        points[0] = new Coordinate(1, 0);
        points[1] = new Coordinate(1, 0);
        points[2] = new Coordinate(1, 0);
        points[3] = new Coordinate(0, 0); // This x is lower than previous x which will result in lic5 as true
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, lcm, new boolean[15][15], new boolean[15]);
        decide.populateCMV();
        decide.populatePUM();

        boolean lic0 = decide.lic0();
        boolean lic5 = decide.lic5();

        assertTrue((lic0 == lic5) && decide.getPum()[0][5]); //Check if both of them are true and if PUM is true

    }

    @Test
    void test_pum_andd_works_2(){
        // Test if PUM turns false if only one lics related through an ANDD is true

        Connectors[][] lcm = new Connectors[15][15];

        // Fill lcm with NOTUSED
        for (Connectors[] row : lcm){
            for(int i = 0; i < row.length; i++){
                row[i] = Connectors.NOTUSED;
            }
        }
        //Set LCM[0,5] and LCM[5,0] to ANDD
        lcm[0][5] = Connectors.ANDD;
        lcm[5][0] = Connectors.ANDD;

        Parameters test_params = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5]; // These Coords together with test params will result in lic0 as true
        points[0] = new Coordinate(1, 0);
        points[1] = new Coordinate(1, 0);
        points[2] = new Coordinate(1, 0);
        points[3] = new Coordinate(1, 0);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, lcm, new boolean[15][15], new boolean[15]);
        decide.populateCMV();
        decide.populatePUM();

        boolean lic0 = decide.lic0();
        boolean lic5 = decide.lic5();

        assertTrue((lic0 != lic5) && !decide.getPum()[0][5]); //Check if one of them is true and if PUM is false

    }

    @Test
    void test_pum_turns_all_true_when_all_notused(){
        // Test if PUM turns false if only one lics related through an ANDD is true

        Connectors[][] lcm = new Connectors[15][15];

        // Fill lcm with NOTUSED
        for (Connectors[] row : lcm){
            for(int i = 0; i < row.length; i++){
                row[i] = Connectors.NOTUSED;
            }
        }

        Parameters test_params = new Parameters(20.41421356237, 3.4, 4.0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5]; // These Coords together with test params will result in lic0 as true
        points[0] = new Coordinate(1, 0);
        points[1] = new Coordinate(1, 0);
        points[2] = new Coordinate(1, 0);
        points[3] = new Coordinate(1, 0);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, lcm, new boolean[15][15], new boolean[15]);
        decide.populateCMV();
        decide.populatePUM();

        boolean[][] test_pum = decide.getPum();

        boolean all_true = true;
        for(int i = 0; i <= 14; i++){ // Loop through all values of test_pum
            for(int j = 0; j <= 14; j++){
                all_true = (test_pum[i][j] && all_true); // Set to false if one case is false
            }
        }
        assertTrue(all_true); //All values in PUM should be true when all in LCM are NOTUSED.

    }
}
