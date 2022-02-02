package decide;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Add functions for points here
    public double area(Coordinate P1, Coordinate P2){
        return Math.abs(0.5*((P1.x-this.x)*(P2.y-this.y)-(P2.x-this.x)*(P1.y-this.y)));
    }

    public double dist(Coordinate P){
        return Math.sqrt(Math.pow(this.x - P.x, 2)+Math.pow(this.y - P.y, 2));
    }


    public double angle(Coordinate P1, Coordinate P2){
        double a=dist(P1);
        double b=dist(P2);
        double c=P1.dist(P2);
        return Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/(2*a*b));
    }

    public boolean isEqual(Coordinate P){
        return this.x == P.x && this.y == P.y;
    }
}