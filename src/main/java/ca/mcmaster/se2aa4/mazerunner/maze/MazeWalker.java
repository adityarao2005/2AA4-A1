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

        path = MazeUtils.toCanonicalPath(path);

        // Initialize the direction and position
        for (int i = 0; i < path.length(); i++) {
            // Get the first position
            char c = path.charAt(i);
            // If the character is not a valid character
            if (c == 'L') {
                direction = direction.moveLeft();
                logger.info("L - Current Direction {}", direction);
            } else if (c == 'R') {
                direction = direction.moveRight();
                logger.info("R - Current Direction {}", direction);
            } else if (c == 'F') {
                // Move the position

                Position newPosition = position.move(direction);
                logger.info("F - Current Position {}, New position {}", position, newPosition);

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
