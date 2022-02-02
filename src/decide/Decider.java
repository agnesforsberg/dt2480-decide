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
        return true;
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

    public boolean lic4(){
        return true;
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
        return true;
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
        return true;
    }

    public boolean lic9(){
        return true;
    }

    public boolean lic10(){
        return true;
    }

    public boolean lic11(){
        return true;
    }

    public boolean lic12(){
        return true;
    }

    public boolean lic13(){
        return true;
    }

    public boolean lic14(){
        return true;
    }
}