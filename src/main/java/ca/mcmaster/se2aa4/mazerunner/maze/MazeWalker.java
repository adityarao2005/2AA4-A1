package ca.mcmaster.se2aa4.mazerunner.maze;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.common.CellType;
import ca.mcmaster.se2aa4.mazerunner.common.Direction;
import ca.mcmaster.se2aa4.mazerunner.common.Position;

public class MazeWalker {
    private static final Logger logger = LogManager.getLogger();

    public boolean verifyPath(Maze maze, String path) {
        logger.trace("Verifying path");

        Direction direction = Direction.RIGHT;
        Position position = maze.getStartPosition();

        Path newPath = new Path(path);

        // Iterate through the path
        for (PathInstruction instruction : newPath) {
            // Get the first position
            char c = instruction.toCharacter();
            // If the character is not a valid character
            if (c == 'L') {
                // Turn left
                direction = direction.moveLeft();
            } else if (c == 'R') {
                // Turn right
                direction = direction.moveRight();
            } else if (c == 'F') {
                // Move the position
                Position newPosition = position.move(direction);

                // If the new position is a wall
                if (!newPosition.isInBounds(maze.getDimensions())) {
                    return false;
                }

                if (maze.getCellType(newPosition) == CellType.WALL) {
                    return false;
                }
                // Update the position
                position = newPosition;
            }
        }

        logger.trace("Finished verifying path");
        // If the path does not reach the end of the maze
        return maze.isEndPosition(position);
    }
}
