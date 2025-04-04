package ca.mcmaster.se2aa4.mazerunner.common;

public class Position {
    private int x;
    private int y;

    public Position() {

    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position move(Direction direction) {
        return new Position(x + direction.getDx(), y + direction.getDy());
    }

    public boolean isInBounds(Position dimensions) {
        return x >= 0 && x < dimensions.getX() && y >= 0 && y < dimensions.getY();
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
