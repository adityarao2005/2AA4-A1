package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeExtractor;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeWalker;
import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.solver.RightHandMazeSolver;

public class MazeCorrectnessTest {
    private MazeSolver solver;
    private MazeWalker walker;
    private Maze maze;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void initialize() throws Exception {
        solver = new RightHandMazeSolver();
        walker = new MazeWalker();
        maze = MazeExtractor.extractMaze("examples/giant.maz.txt");

        logger.info("Maze Dimensions: {}\n", maze.getDimensions());
    }

    @Test
    public void testCorrectness() {
        String path = solver.solveMaze(maze);
        logger.info("Path: {}", path);
        assertTrue(walker.verifyPath(maze, path));
    }

}
