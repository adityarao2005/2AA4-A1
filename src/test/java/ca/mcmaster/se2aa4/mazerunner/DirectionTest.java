package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.common.Direction;

public class DirectionTest {

    @Test
    public void testUp() {
        Direction direction = Direction.UP;
        assertEquals(Direction.LEFT, direction.moveLeft());
        assertEquals(Direction.RIGHT, direction.moveRight());
        assertEquals(Direction.DOWN, direction.opposite());

    }

    @Test
    public void testLeft() {
        Direction direction = Direction.LEFT;
        assertEquals(Direction.DOWN, direction.moveLeft());
        assertEquals(Direction.UP, direction.moveRight());
        assertEquals(Direction.RIGHT, direction.opposite());
    }

    @Test
    public void testDown() {
        Direction direction = Direction.DOWN;
        assertEquals(Direction.RIGHT, direction.moveLeft());
        assertEquals(Direction.LEFT, direction.moveRight());
        assertEquals(Direction.UP, direction.opposite());
    }

    @Test
    public void testRight() {
        Direction direction = Direction.RIGHT;
        assertEquals(Direction.UP, direction.moveLeft());
        assertEquals(Direction.DOWN, direction.moveRight());
        assertEquals(Direction.LEFT, direction.opposite());
    }
}
