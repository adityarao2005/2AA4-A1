package ca.mcmaster.se2aa4.mazerunner.maze;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.common.Direction;
import ca.mcmaster.se2aa4.mazerunner.common.Position;
import ca.mcmaster.se2aa4.mazerunner.maze.path.Path;
import ca.mcmaster.se2aa4.mazerunner.maze.path.PathInstruction;

public class MazeWalker {
    private static final Logger logger = LogManager.getLogger();
    private Direction direction;
    private Position position;
    private Maze maze;
    private Path path;

    public MazeWalker(Maze maze, String path) {
        this.direction = Direction.RIGHT;
        this.maze = maze;
        this.position = maze.getStartPosition();

        this.path = new Path(path);
    }

    public boolean verifyPath() {
        logger.trace("Verifying path");

        // Iterate through the path
        for (PathInstruction instruction : path) {
            // Get the first position
            if (!instruction.execute(this))
                return false;
        }

        logger.trace("Finished verifying path");
        // If the path does not reach the end of the maze
        return maze.isEndPosition(position);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Maze getMaze() {
        return maze;
    }

    public Position forward() {
        return (position = position.move(direction));
    }

    public void turnLeft() {
        direction = direction.moveLeft();
    }

    public void turnRight() {
        direction = direction.moveRight();
    }
}
