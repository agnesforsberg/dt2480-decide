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
        return 0.5*((P1.x-this.x)*(P2.y-this.y)-(P2.x-this.x)*(P1.y-this.y));
    }
}