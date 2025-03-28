package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.common.Direction;
import ca.mcmaster.se2aa4.mazerunner.common.Position;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void initialize() {
        position = new Position(0, 0);
    }

    @Test
    public void testPositionInitialization() {
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testSetPosition() {
        position.setX(5);
        position.setY(10);
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    public void testInBounds() {
        Position mazeDimensions = new Position(10, 10);

        // test if in bounds
        assertTrue(position.isInBounds(mazeDimensions));
        // test x out of bounds
        position.setX(10);
        assertFalse(position.isInBounds(mazeDimensions));
        // test x out of bounds
        position.setX(0);
        position.setY(10);
        assertFalse(position.isInBounds(mazeDimensions));
        // test negative x
        position.setY(0);
        position.setX(-1);
        assertFalse(position.isInBounds(mazeDimensions));
        // test negative y
        position.setX(0);
        position.setY(-1);
        assertFalse(position.isInBounds(mazeDimensions));
        // Test center
        position.setX(5);
        position.setY(5);
        assertTrue(position.isInBounds(mazeDimensions));
    }

    @Test
    public void testMoveLeft() {
        position = position.move(Direction.LEFT);
        assertEquals(-1, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testMoveRight() {
        position = position.move(Direction.RIGHT);
        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testMoveUp() {
        position = position.move(Direction.UP);
        assertEquals(-1, position.getY());
        assertEquals(0, position.getX());
    }

    @Test
    public void testMoveDown() {
        position = position.move(Direction.DOWN);
        assertEquals(1, position.getY());
        assertEquals(0, position.getX());
    }
}
