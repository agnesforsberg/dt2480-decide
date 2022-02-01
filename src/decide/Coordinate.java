package decide;

public class Coordinate {
    private int x;
    private int y;

    static double PI = 3.1415926535;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Setters
    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    // Getters
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isEqual(Coordinate c){
        return this.x == c.x && this.y == c.y;
    }

    public double dist(Coordinate P){
        return Math.sqrt(Math.pow(this.x - P.x, 2)+Math.pow(this.y - P.y, 2));
    }

    public double angle(Coordinate P1, Coordinate P2){
        // I think this calculation is wrong? I got the wrong result for a straight line.
        // double scal  = (P1.x-this.x)*(P2.x-this.x)+(P1.y-this.y)*(P2.y-this.y);
        // return Math.acos(scal/(dist(P1)+dist(P2)));
        double result = Math.atan2(P2.y - this.y, P2.x - this.x) -
                Math.atan2(P1.y - this.y, P1.x - this.x);
        if(result < 0){
            result += 2*PI;
        }
        return result;
    }

    public int getQuadrant() {
        if(this.x >= 0 && this.y >= 0){
            return 1;
        } else if(this.x < 0 && this.y >= 0){
            return 2;
        }else if(this.x <= 0 && this.y < 0){
            return 3;
        }else {
            // c.x < 0 && c.y < 0
            return 4;
        }
    }
}