package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeExtractor;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeUtils;
import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.solver.RightHandMazeSolver;

public class PathTest {
    private MazeSolver solver;
    private Maze maze;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void initialize() throws Exception {
        solver = new RightHandMazeSolver();
        maze = MazeExtractor.extractMaze("examples/giant.maz.txt");

        logger.info("Maze Dimensions: {}\n", maze.getDimensions());
    }
    
    @Test
    public void testPathEquivalence() {
        String factoredPath = solver.solveMaze(maze);
        logger.info("Factored Path: {}", factoredPath);
        String canonicalPath = MazeUtils.toCanonicalPath(factoredPath);
        logger.info("Canonical Path: {}", canonicalPath);
        String newFactoredPath = MazeUtils.toFactoredPath(canonicalPath);
        logger.info("New Factored Path: {}", newFactoredPath);
        assertEquals(factoredPath, newFactoredPath);
    }
}
