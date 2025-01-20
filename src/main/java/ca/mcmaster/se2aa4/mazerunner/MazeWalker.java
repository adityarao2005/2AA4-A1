package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
            } else if (c == 'R') {
                direction = direction.moveRight();
            } else if (c == 'F') {
                // Move the position
                Position newPosition = position.move(direction);
                // If the new position is a wall
                if (maze.isEndPosition(newPosition)) {
                    return true;
                }
                // Update the position
                position = newPosition;
            }

            if (position.getX() == maze.getDimensions().getX())
                return true;
        }

        logger.trace("Finished verifying path");
        // If the path does not reach the end of the maze
        return maze.isEndPosition(position);
    }
}
