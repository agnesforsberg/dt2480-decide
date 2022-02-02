import decide.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void getX() {
        Coordinate c = new Coordinate(34, 12);
        assertEquals(c.getX(), 34);

    }

    @Test
    void getY() {
        Coordinate c = new Coordinate(347, 75);
        assertEquals(c.getY(), 75);
    }

    @Test
    void setX() {
        Coordinate c = new Coordinate(1, 2);
        c.setX(4);
        assertEquals(c.getX(), 4);
    }

    @Test
    void setY() {
        Coordinate c = new Coordinate(1, 2);
        c.setY(4);
        assertEquals(c.getY(), 4);
    }

    @Test
    void distanceToCoordinate() {
        Coordinate c1 = new Coordinate(1, 1);
        Coordinate c2 = new Coordinate(0, 0);
        Coordinate c3 = new Coordinate(1, 0);

        assertEquals(c1.distanceToCoordinate(c2), 1.4142135623730951);
        assertEquals(c2.distanceToCoordinate(c3), 1.0);
        assertEquals(c2.distanceToCoordinate(c2), 0.0);
    }

    @Test
    void coordinateInOrOnCircle(){
        Coordinate c1_on_circle = new Coordinate(1, 0);
        Coordinate c2_in_circle = new Coordinate(1, 1);
        Coordinate c3_outside_circle = new Coordinate(2,2);

        assertTrue(c1_on_circle.coordinateInOrOnCircle(1,1,1));
        assertTrue(c2_in_circle.coordinateInOrOnCircle(1,1,1));
        assertFalse(c3_outside_circle.coordinateInOrOnCircle(1,1,1));
    }

    @Test
    void Coordinate() {
        Coordinate c = new Coordinate(1, 2);
        assertEquals(c.getX(), 1);
        assertEquals(c.getY(), 2);
    }
}