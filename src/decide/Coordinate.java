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

    public boolean isEqual(Coordinate P){
        return this.x == P.x && this.y == P.y;
    }

    public double dist(Coordinate P){
        return Math.sqrt(Math.pow(this.x - P.x, 2)+Math.pow(this.y - P.y, 2));
    }

    public double angle(Coordinate P1, Coordinate P2){
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

    public double distanceToCoordinate(Coordinate other){
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    public boolean coordinateInOrOnCircle(double radius, double center_x, double center_y){
        return (((this.x - center_x)*(this.x - center_x)) + ((this.y - center_y)*(this.y - center_y))) <= (radius*radius);
    }

    public double area(Coordinate P1, Coordinate P2){
        return Math.abs(0.5*((P1.x-this.x)*(P2.y-this.y)-(P2.x-this.x)*(P1.y-this.y)));
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