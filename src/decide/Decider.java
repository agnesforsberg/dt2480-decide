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
        this.pum = this.pum;
        // to put all testresults in
        this.cmv = new boolean[15];
    }

    public boolean decide(){
        //TODO run all LICs
        return true;
    }

    public boolean lic0(){
        return true;
    }

    public boolean lic1(){
        return true;
    }

    public boolean lic2(){
        return true;
    }

    public boolean lic3(){
        return true;
    }

    public boolean lic4(){
        return true;
    }

    public boolean lic5(){
        return true;
    }

    public boolean lic6(){
        return true;
    }

    public boolean lic7(){
        return true;
    }

    public boolean lic8(){
        return true;
    }

    public boolean lic9(){
        return true;
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