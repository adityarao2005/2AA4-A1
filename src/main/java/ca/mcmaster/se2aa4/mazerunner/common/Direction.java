package ca.mcmaster.se2aa4.mazerunner.common;

public enum Direction {
    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    private int dx;
    private int dy;
    private Direction left;
    private Direction right;
    private Direction opposite;

    static {
        UP.left = DOWN.right = RIGHT.opposite = LEFT;
        DOWN.left = UP.right = LEFT.opposite = RIGHT;
        LEFT.left = RIGHT.right = UP.opposite = DOWN;
        RIGHT.left = LEFT.right = DOWN.opposite = UP;
    }

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;

    }

    public Direction opposite() {
        return opposite;
    }

    public Direction moveLeft() {
        return left;
    }

    public Direction moveRight() {
        return right;
    }

    protected int getDx() {
        return dx;
    }

    protected int getDy() {
        return dy;
    }
}
