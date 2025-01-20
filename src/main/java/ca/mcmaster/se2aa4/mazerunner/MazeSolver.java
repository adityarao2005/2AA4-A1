package ca.mcmaster.se2aa4.mazerunner;

public interface MazeSolver {

    public String solveMaze(Maze maze);

    public default Position getStartPosition(Maze maze) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public default boolean isEndPosition(Maze maze, Position position) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
