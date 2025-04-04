package ca.mcmaster.se2aa4.mazerunner.maze.path;

import ca.mcmaster.se2aa4.mazerunner.common.CellType;
import ca.mcmaster.se2aa4.mazerunner.common.Position;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeWalker;

public class ForwardInstruction extends PathInstruction {
    @Override
    public boolean execute(MazeWalker walker) {
        // Turn right
        Maze maze = walker.getMaze();

        Position position = walker.forward();

        // If the new position is a wall
        if (!position.isInBounds(maze.getDimensions())) {
            return false;
        }

        if (maze.getCellType(position) == CellType.WALL) {
            return false;
        }

        return true;
    }

    @Override
    public char toCharacter() {
        return 'F';
    }

}
