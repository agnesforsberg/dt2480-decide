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