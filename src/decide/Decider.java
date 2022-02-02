package decide;

public class Decider{
    private int numpoints;
    private Coordinate[] points;
    private Parameters parameters;
    private Connectors[][] lcm;
    private boolean[][] pum;
    private boolean[] cmv;
    private boolean[] fuv;

    static double PI = 3.1415926535;

    public Decider(int numpoints, Coordinate[] points, Parameters parameters, Connectors[][] lcm, boolean[][] pum){
        this.numpoints = numpoints;
        this.points = points;
        this.parameters = parameters;
        this.lcm = lcm;
        this.pum = pum;
        // to put all testresults in
        this.cmv = new boolean[15];
        this.fuv = new boolean[15];
    }

    public boolean decide(){
        /**
         * populates all the necessary data structures for launch to do its decision.

         * @return  Boolean representing if interception missile should be launched or not.
         */

        populateCMV(); // Populates the CMV
        populatePUM(); // Populates the PUM
        populateFUV(); // Populates the FUV

        return launch();

    }

    public void populateCMV(){
        /**
         * runs all LICs and populates the CMV.
         */
        this.cmv[0] = lic0();
        this.cmv[1] = lic1();
        this.cmv[2] = lic2();
        this.cmv[3] = lic3();
        this.cmv[4] = lic4();
        this.cmv[5] = lic5();
        this.cmv[6] = lic6();
        this.cmv[7] = lic7();
        this.cmv[8] = lic8();
        this.cmv[9] = lic9();
        this.cmv[10] = lic10();
        this.cmv[11] = lic11();
        this.cmv[12] = lic12();
        this.cmv[13] = lic13();
        this.cmv[14] = lic14();
    }

    public void populatePUM(){
        /**
         The Conditions Met Vector (CMV) is used in conjunction with the Logical Connector
         Matrix (LCM) to form the Preliminary Unlocking Matrix (PUM). The entries in the LCM represent
         the logical connectors to be used between pairs of LICs to determine the corresponding entry in
         the PUM, i.e. LCM[i,j] represents the boolean operator to be applied to CMV[i] and CMV[j].
         PUM[i,j] is set according to the result of this operation.

         If LCM[i,j] is NOTUSED, then PUM[i,j]
         should be set to true.

         If LCM[i,j] is ANDD, PUM[i,j] should be set to true only if (CMV[i] AND
         CMV[j]) is true.

         If LCM[i,j] is ORR, PUM[i,j] should be set to true if (CMV[i] OR CMV[j]) is
         true.

         (Note that the LCM is symmetric, i.e. LCM[i,j]=LCM[j,i] for all i and j.)
         */

        for(int i = 0; i <= 14; i++){ // Loop through LCM.
            for(int j = i; i <= 14; i++){
                switch(this.lcm[i][j]){ // Switch to do the proper operations &&, || or auto true.
                    case ANDD:
                        this.pum[i][j] = (this.cmv[i] && this.cmv[j]);
                        break;

                    case ORR:
                        this.pum[i][j] = (this.cmv[i] || this.cmv[j]);
                        break;

                    case NOTUSED:
                        this.pum[i][j] = true;
                        break;

                    default: // If something is not configured correctly in the LCM that PUM position is set to false.
                        this.pum[i][j] = false;
                        break;
                }
                this.pum[j][i] = this.pum[i][j]; //Symetrize Matrix
            }
        }
    }

    public void populateFUV(){
        //Please populate FUV, thank you.
    }

    public boolean launch(){
        /**
         * Loops through the FUV to check if all values in the FUV is set to true or not.

         * @return  Boolean representing if all values in the FUV is set to true or not.
         */
        return true;
    }

    public boolean lic0(){
        /**
         * Returns a Boolean representing if there exists at least one set of two
         * consecutive data points that are a distance greater than
         * the length, LENGTH1, apart. (0 ≤ LENGTH1)

         * @return  Boolean representing if the condition is met or not.
         */

        boolean condition_met = false;  // Boolean to keep track if condition has been met.

        for(int i = 0; i <= this.numpoints-2 && !condition_met; i++){ // Loop through all Coordinates in points[]
            //compare distance between all points i and i+1.
            condition_met = ((this.points[i].distanceToCoordinate(this.points[i+1]) > this.parameters.LENGTH1) || condition_met);
        }
        return condition_met;
    }

    public boolean lic1(){
        /**
         * There exists at least one set of three consecutive data points that cannot all be contained
         * within or on a circle of radius RADIUS1. (0 ≤ RADIUS1)
         *
         * @return Boolean representing if the condition is met or not.
         */
        boolean condition_met;
        for(int i = 0; i < this.numpoints-2; i++){
            double center_x = (double) (this.points[i].getX() +this.points[i+1].getX() + this.points[i+2].getX())/3;
            double center_y = (double) (this.points[i].getY() +this.points[i+1].getY() + this.points[i+2].getY())/3;
            condition_met = !(this.points[i].coordinateInOrOnCircle(this.parameters.RADIUS1, center_x, center_y) &&
                    this.points[i+1].coordinateInOrOnCircle(this.parameters.RADIUS1, center_x, center_y) &&
                    this.points[i+2].coordinateInOrOnCircle(this.parameters.RADIUS1, center_x, center_y));

            if(condition_met) return true;
        }
        return false;
    }


    public boolean lic2(){
        boolean lic2_value = false;
        int i = 0;
        Coordinate P1;
        Coordinate P2;
        Coordinate P3;
        double angle;
        while (!lic2_value && i < this.numpoints-2){
            P1 = this.points[i];
            P2 = this.points[i + 1];
            P3 = this.points[i + 2];
            if(!(P1.isEqual(P2) || P1.isEqual(P3))){
                angle = P1.angle(P2,P3);
                if (angle <Math.PI - this.parameters.EPSILON || angle >Math.PI + this.parameters.EPSILON){
                    lic2_value = true;
                }
            };
            i++;
        };
        return lic2_value;
    }

    public boolean lic3(){
        /*If there exists at least one set of three consecutive data points that are the vertices of a triangle
with area greater than AREA1 */

        boolean condition = false;
        int i = 0;
        Coordinate P1;
        Coordinate P2;
        Coordinate P3;
        double area;
        while ( i < this.numpoints-2 && !condition ){
            P1 = this.points[i];
            P2 = this.points[i + 1];
            P3 = this.points[i + 2];
            double a = P1.area(P2,P3);
            if (a>=this.parameters.AREA1) {
                condition = true;
            }
            i++;
            
        }
        return condition;

    }


    /** Returns a Boolean representing if there exists at least one set of Q_PTS consecutive data points
     * that lie in more than QUADS quadrants. Where there is ambiguity as to which quadrant contains a given point,
     * priority of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I.
     * (2 ≤ Q_PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
     *
     * @return  Boolean representing if the condition is met or not.*/
    public boolean lic4(){
        // false in case of invalid parameters
        if(this.parameters.Q_PTS < 2 || this.parameters.Q_PTS > numpoints){
            return false;
        }
        if(this.parameters.QUADS < 1 || this.parameters.QUADS > 3){
            return false;
        }

        int[] pointQuads = new int[numpoints];

        for(int i = 0; i < numpoints; i++){
            pointQuads[i] = points[i].getQuadrant();
        }

        int[] oldQuads;
        int numDifferentQuads;
        int newQuad;
        for(int j = 0; (j+this.parameters.Q_PTS) <= numpoints; j++){
            oldQuads = new int[4];
            oldQuads[pointQuads[j]-1] = 1;
            numDifferentQuads = 1;
            for(int k = 1; k < this.parameters.Q_PTS; k++){
                newQuad = pointQuads[j+k];
                // If point is in new quadrant, mark quadrant as used
                if(oldQuads[newQuad-1] == 0){
                    numDifferentQuads += 1;
                    oldQuads[newQuad-1] = 1;
                }
            }
            if(numDifferentQuads > this.parameters.QUADS){
                return true;
            }
        }

        return false;
    }

    public boolean lic5(){
        /**
         * Returns a Boolean representing if there exists at least one set of two consecutive data points,
         * (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)

         * @return  Boolean representing if the condition is met or not.
         */

        boolean condition_met = false;  // Boolean to keep track if condition has been met.

        for(int i = 0; i <= this.numpoints-2 && !condition_met; i++){ // Loop through all Coordinates in points[]
            //check if points[i].x is greater than points[i+1].x for all points. Will break loop if true.
            condition_met = (this.points[i+1].getX() < this.points[i].getX() || condition_met);
        }
        return condition_met;
    }

    public boolean lic6(){
        /***
         * There exists at least one set of N PTS consecutive data points such that at least one of the
         * points lies a distance greater than DIST from the line joining the first and last of these N PTS
         * points. If the first and last points of these N PTS are identical, then the calculated distance
         * to compare with DIST will be the distance from the coincident point to all other points of
         * the N PTS consecutive points. The condition is not met when NUMPOINTS < 3.
         * (3 ≤ N PTS ≤ NUMPOINTS), (0 ≤ DIST)
         *
         * @return Boolean representing if the condition is met or not.
         */

        if(this.numpoints < 3) return false;

        boolean condition_met;
        double distance;
        for(int i = 0; i < this.numpoints-(this.parameters.N_PTS-1); i++){
            if(!this.points[i].isEqual(this.points[i + this.parameters.N_PTS-1])){
                int line_x = this.points[i + this.parameters.N_PTS-1].getX() - this.points[i].getX();
                int line_y = this.points[i + this.parameters.N_PTS-1].getY() - this.points[i].getY();
                double line_m = Math.sqrt((line_x*line_x) + (line_y*line_y));
                for(int j = i+1; j < i+this.parameters.N_PTS-1; j++){
                    distance = Math.abs(line_x*(this.points[i].getY() - this.points[j].getY()) - line_y*(this.points[i].getX() - this.points[j].getX()))/line_m;
                    condition_met = distance > this.parameters.DIST;
                    if(condition_met) return true;
                }
            }
            else{
                for(int j = i+1; j < i+this.parameters.N_PTS-1; j++){
                    distance = this.points[j].distanceToCoordinate(this.points[i]);
                    condition_met = distance > this.parameters.DIST;
                    if(condition_met) return true;
                }
            }
        }

        return false;
    }


    public boolean lic7(){
        boolean value_lic7 = false;
        Coordinate P1;
        Coordinate P2;
        int i = 0;
        if(this.parameters.K_PTS >= 1){
            while(!value_lic7 && i+ this.parameters.K_PTS  < this.numpoints -1){
                P1 = this.points[i];
                P2 = this.points[i+this.parameters.K_PTS +1];
                if(P1.dist(P2) > this.parameters.LENGTH1){
                    value_lic7 = true;
                }
                i++;
            }
        }
        
        return value_lic7;
    }

    public boolean lic8(){
        /*If there exists at least one set of three data points separated by exactly A PTS and B PTS
consecutive intervening points, respectively, that cannot be contained within or on a circle of
radius RADIUS1. The condition is not met when NUMPOINTS < 5 */ 
        boolean condition = false;
        int i = 0;
        Coordinate P1;
        Coordinate P2;
        Coordinate P3;
        double R;
        double a;
        double b;
        double c;
        double a1;  // angles
        double a2;
        double a3;
        while ( i < this.numpoints-2-this.parameters.A_PTS-this.parameters.B_PTS && !condition ){
            
            P1 = this.points[i];
            P2 = this.points[i + this.parameters.A_PTS+1];
            P3 = this.points[i + this.parameters.A_PTS+this.parameters.B_PTS+2];
            if (P1.isEqual(P2) && P1.isEqual(P3)){     //case 3 identic points, R=0
                i++;
                break;
            }
            a=P1.dist(P2);
            b=P1.dist(P3);
            c=P2.dist(P3);
            a1=P1.angle(P2, P3);
            a2=P2.angle(P1, P3);
            a3=P3.angle(P1, P2);
            if (P1.isEqual(P2) || P1.isEqual(P3)|| P2.isEqual(P3)){  //case 2 identic points R is equal to the dist with 3rd
                R=Math.max(a, Math.max(b, c))/2;
                
            }
            else if(a1>Math.PI/2 ||a2>Math.PI/2 ||a3>Math.PI/2){  // obtuse angle case cercle has a side of the triangle as diameter
                R=Math.max(a, Math.max(b, c))/2;
            }
            else{           // acute angle case , we compute the radius of the circumscribed circle
                R=a*b*c/(4*P1.area(P2,P3));
            }
            if (R>this.parameters.RADIUS1){
                condition=true;
            }
            i++;

        }
        return condition;
    }

    /**Returns a Boolean representing if there exists at least one set of three data points separated by exactly C PTS and D PTS
     consecutive intervening points, respectively, that form an angle such that:
     angle < (PI−EPSILON)
     or
     angle > (PI+EPSILON)
     The second point of the set of three points is always the vertex of the angle. If either the first
     point or the last point (or both) coincide with the vertex, the angle is undefined and the LIC
     is not satisfied by those three points. When NUMPOINTS < 5, the condition is not met.
     1 ≤ C PTS, 1 ≤ D PTS
     C PTS+D PTS ≤ NUMPOINTS−3

     @return  Boolean representing if the condition is met or not**/
    public boolean lic9(){
        // False if preconditions not met
        if(numpoints < 5 || this.parameters.C_PTS < 1 || this.parameters.D_PTS < 1 ||
                (this.parameters.C_PTS + this.parameters.D_PTS) > (numpoints - 3)){
            return false;
        }

        Coordinate x, y, z;
        double angle;
        int c = this.parameters.C_PTS;
        int d = this.parameters.D_PTS;
        double epsilon = this.parameters.EPSILON;

        for(int i = 0; i < (numpoints - c - d - 2); i++){
            x = points[i];
            y = points[i+c+1];
            z = points[i+c+d+2];
            if(!y.isEqual(x) && !y.isEqual(z)){
                angle = y.angle(x, z);
                if(angle < (PI - epsilon) || angle > (PI + epsilon)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean lic10(){
        /**
         * Returns a Boolean representing if there exists at least one set of three data points separated by
         * exactly E PTS and F PTS consecutive intervening points, respectively, that are the vertices of a
         * triangle with area greater than AREA1. The condition is not met when NUMPOINTS < 5.
         * 1 ≤ E PTS, 1 ≤ F PTS
         * E PTS+F PTS ≤ NUMPOINTS−3
         *
         *  @return  Boolean representing if the condition is met or not.
         */

        //Error handling
        if((this.parameters.E_PTS + this.parameters.F_PTS > this.numpoints) || (this.parameters.E_PTS < 1) || (this.parameters.F_PTS < 1)){
            return false;
            //Maybe throw an error.
        }
        if (this.numpoints < 5){ // The condition is not met when NUMPOINTS < 5
            return false;
        }

        boolean condition_met = false;      // Boolean to keep track if condition has been met.
        int e = this.parameters.E_PTS;      // Just a shorthand for convenience.
        int f = this.parameters.F_PTS;      // Just a shorthand for convenience.
        double a, b, c, s, triangle_area;   // Used to keep calculation of the area of the Triangle readable.


        for(int i = 0; i <= this.numpoints-3-e-f && !condition_met; i++){ // Loop through all suitable points.

            // Perform Heron's formula to calculate Area of Triangle
            a = this.points[i].distanceToCoordinate(this.points[i+e+1]);
            b = this.points[i].distanceToCoordinate(this.points[i+e+f+2]);
            c = this.points[i+e+1].distanceToCoordinate(this.points[i+e+f+2]);
            s = (a + b + c)/2;

            triangle_area = Math.sqrt(s*(s - a)*(s - b)*(s - c));
            System.out.println(a + " " + b + " " + c);
            System.out.println(i + ", " + (i+e+1) + ", " + (i+e+f+2) + ": " + triangle_area);

            condition_met = (triangle_area > this.parameters.AREA1 || condition_met);
        }
        return condition_met;

    }

    public boolean lic11(){
        /***
         * There exists at least one set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by
         * exactly G PTS consecutive intervening points, such that X[j] - X[i] < 0. (where i < j ) The
         * condition is not met when NUMPOINTS < 3.
         * 1 ≤ G PTS ≤ NUMPOINTS−2
         *
         * @return Boolean representing if the condition is met or not.
         */
        if(this.numpoints < 3) return false;

        boolean condition_met;
        for(int i = 0; i < this.numpoints - (this.parameters.G_PTS + 1); i++){
            condition_met = (this.points[i+ this.parameters.G_PTS+1].getX() - this.points[i].getX()) < 0;
            if(condition_met) return true;
        }
        return false;
    }

    public boolean lic12(){
        boolean upper = false;
        boolean lower = false;
        Coordinate P1;
        Coordinate P2;
        int i = 0;
        double distance;
        if(this.parameters.K_PTS >= 1){
            while(!(upper && lower) && i+ this.parameters.K_PTS  < this.numpoints -1){
                P1 = this.points[i];
                P2 = this.points[i+this.parameters.K_PTS +1];
                distance = P1.dist(P2);
                if(distance > this.parameters.LENGTH1){
                    upper = true;
                }
                if(distance < this.parameters.LENGTH2){
                    lower = true;
                }
                i++;
            }
        }
        
        return upper && lower;
    }

    public boolean lic13(){
        return true;
    }

    /**Returns a Boolean representing if there exists at least one set of three data points, separated by exactly E PTS
     and F PTS consecutive intervening points, respectively, that are the vertices of a triangle with area greater
     than AREA1. In addition, there exist three data points (which can be the same or different
     from the three data points just mentioned) separated by exactly E PTS and F PTS consecutive intervening points,
     respectively, that are the vertices of a triangle with area less than
     AREA2. Both parts must be true for the LIC to be true. The condition is not met when
     NUMPOINTS < 5.
     0 ≤ AREA2

     @return  Boolean representing if the condition is met or not**/
    public boolean lic14(){
        if(numpoints < 5){
            return false;
        }

        int e = this.parameters.E_PTS;
        int f = this.parameters.F_PTS;

        boolean firstCriteria = false;
        boolean secondCriteria = false;

        for(int i = 0; i < (numpoints - e - f - 2); i++){
            double area = points[i].triangleArea(points[i+e+1], points[i+e+f+2]);

            if(area > this.parameters.AREA1){
                firstCriteria = true;
            }
            if(area < this.parameters.AREA2){
                secondCriteria = true;
            }
        }

        return firstCriteria && secondCriteria;
    }
}