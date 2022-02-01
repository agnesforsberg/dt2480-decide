package decide;

public class Coordinate {
    private int x;
    private int y;

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


    // Misc
    public double distanceToCoordinate(Coordinate other){
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }
}