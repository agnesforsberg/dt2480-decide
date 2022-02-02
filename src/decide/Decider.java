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
        this.pum =pum;
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