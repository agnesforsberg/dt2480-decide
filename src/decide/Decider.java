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
        return true;
    }

    public boolean lic11(){
        return true;
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