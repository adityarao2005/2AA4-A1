package ca.mcmaster.se2aa4.mazerunner;

public enum CellType {
    WALL,
    PASSAGE;

    public boolean isWall() {
        return this == WALL;
    }

    public static CellType fromChar(char c) {
        if (c == '#') {
            return WALL;
        } else if (c == ' ') {
            return PASSAGE;
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
        }
    }
}
