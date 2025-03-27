package ca.mcmaster.se2aa4.mazerunner.solver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.common.Direction;
import ca.mcmaster.se2aa4.mazerunner.common.Position;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeUtils;

public class LeftHandMazeSolver implements MazeSolver {
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

            // 5 states
            // _____________
            // Case 1: __. |
            // ==========| |
            // WHen there is a wall in the front and no wall to the left
            // what to do? turn left and go straight 1
            //
            // ____________| |
            // Case 2: ____. X
            // ============| |
            // When there is no wall in the front and in the left
            // what to do? turn left and go straight 1
            //
            // _______________
            // Case 3: | .____
            // ========| |
            // When there is a wall in the front and in the left
            // What to do? turn right and go straight 1
            // | |
            // Case 4 | |
            // =======| |
            // When there is no wall in the front and but a wall in the left
            // What to do? go straight 1
            // _________
            // Case 5 | |
            // =======| |
            // When there is no wall in the front and no wall in the left
            // What to do? turn left and go straight 1
            boolean leftWall = maze.getCellType(position.move(direction.moveLeft())).isWall();
            boolean frontWall = maze.getCellType(position.move(direction)).isWall();
            boolean rightWall = maze.getCellType(position.move(direction.moveRight())).isWall();

            // Case 1, 2 - turn left since no left wall
            if (!leftWall) {
                direction = direction.moveLeft();
                path.append("L");

                // Case 3, 5 -
            } else if (frontWall) {
                if (!rightWall) {
                    // Case 3 - turn right since no right wall
                    direction = direction.moveRight();
                    path.append("R");
                } else {
                    // Case 5 - reverse since we've reached a dead end
                    direction = direction.opposite();
                    path.append("LL");
                }
            }
            // Don't need to change direction for right wall (Case 4)
            path.append("F");
            position = position.move(direction);
        }

        logger.trace("Finished solving maze");
        return MazeUtils.toFactoredPath(path.toString());
    }

}
