package decide;

public class Decider{
    private int numpoints;
    private Coordinate[] points;
    private Parameters parameters;
    private Connectors[][] lcm;
    private boolean[][] pum;
    private boolean[] cmv;

    public Decider(int numpoints, Coordinate[] points, Parameters parameters, Connectors[][] lcm, boolean[][] pum){
        this.numpoints = numpoints;
        this.points = points;
        this.parameters = parameters;
        this.lcm = lcm;
        this.pum = pum;
        // to put all testresults in
        this.cmv = new boolean[15];
    }

    public boolean decide(){
        //TODO run all LICs
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

    public boolean lic9(){
        return true;
    }

    public boolean lic10(){
        return true;
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

    public boolean lic14(){
        return true;
    }
}