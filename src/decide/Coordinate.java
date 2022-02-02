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

    public boolean isEqual(Coordinate P){
        return this.x == P.x && this.y == P.y;
    }

    public double dist(Coordinate P){
        return Math.sqrt(Math.pow(this.x - P.x, 2)+Math.pow(this.y - P.y, 2));
    };
      
    public double angle(Coordinate P1, Coordinate P2){
        double a=dist(P1);
        double b=dist(P2);
        double c=P1.dist(P2);
        return Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/(2*a*b));
    }

    public double distanceToCoordinate(Coordinate other){
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
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