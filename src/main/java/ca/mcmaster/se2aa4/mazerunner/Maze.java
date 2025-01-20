package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private CellType[][] maze;

    public Maze(char[][] maze) {

    }

    public CellType getCellType(Position position) {
        return maze[position.getX()][position.getY()];
    }

    public Position getDimensions() {
        return new Position(maze.length, maze[0].length);
    }
}
