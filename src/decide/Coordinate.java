package decide;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Add functions for points here

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