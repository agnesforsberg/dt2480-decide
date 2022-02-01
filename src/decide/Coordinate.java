package decide;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isEgal(Coordinate P){
        return this.x == P.x && this.y == P.y;
    }

    public double dist(Coordinate P){
        return Math.sqrt(Math.pow(this.x - P.x, 2)+Math.pow(this.y - P.y, 2));
    };

    public double angle(Coordinate P1, Coordinate P2){
        double scal  = (P1.x-this.x)*(P2.x-this.x)+(P1.y-this.y)*(P2.y-this.y);
        return Math.acos(scal/(dist(P1)+dist(P2)));
    }
    // Add functions for points here
}