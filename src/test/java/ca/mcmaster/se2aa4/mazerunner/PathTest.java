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

    @Test
    public void testToCanonical() {
        String factoredPath = "5F 3L 2F 4R 5F";
        String canonicalPath = MazeUtils.toCanonicalPath(factoredPath);
        assertEquals("FFFFFLLLFFRRRRFFFFF", canonicalPath);

        factoredPath = "10F 3R F";
        canonicalPath = MazeUtils.toCanonicalPath(factoredPath);
        assertEquals("FFFFFFFFFFRRRF", canonicalPath);
    }

    @Test
    public void testToFactored() {
        String canonicalPath = "FFFFFLLLFFRRRRFFFFF";
        String factoredPath = MazeUtils.toFactoredPath(canonicalPath);
        assertEquals("5F3L2F4R5F", factoredPath);

        canonicalPath = "FFFFFFFFFFRRRF";
        factoredPath = MazeUtils.toFactoredPath(canonicalPath);
        assertEquals("10F3RF", factoredPath);
    }
}

// TODO: Iterator pattern - iterate over the path
// TODO: Factory pattern - create a maze
// TODO: Maybe talk about chain of responsibility pattern