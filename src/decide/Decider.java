package decide;

public class Decider{
    private int numpoints;
    private Coordinate[] points;
    private Parameters parameters;
    private Connectors[][] lcm;
    private boolean[][] pum;
    private boolean[] cmv;

    static double PI = 3.1415926535;

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