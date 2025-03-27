package ca.mcmaster.se2aa4.mazerunner.solver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.common.Direction;
import ca.mcmaster.se2aa4.mazerunner.common.Position;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeUtils;

public class MVPMazeSolver implements MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String solveMaze(Maze maze) {
        logger.trace("Solving maze using left hand rule");

        // Path to be returned
        StringBuilder path = new StringBuilder();
        // Initialize the direction and position
        Direction direction = Direction.RIGHT;
        Position position = maze.getStartPosition();

        // Continue to do this until you are not at the end of the maze
        while (!maze.isEndPosition(position)) {
            // Trivial implementation is go forward
            path.append("F");
            position = position.move(direction);

        }

        logger.trace("Finished solving maze");
        return MazeUtils.toFactoredPath(path.toString());
    }

}
