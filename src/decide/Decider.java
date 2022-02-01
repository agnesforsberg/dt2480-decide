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