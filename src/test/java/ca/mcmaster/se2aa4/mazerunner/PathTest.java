package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeExtractor;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeUtils;
import ca.mcmaster.se2aa4.mazerunner.maze.Path;
import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.solver.RightHandMazeSolver;

public class PathTest {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testPathEquivalence() throws Exception {
        MazeSolver solver = new RightHandMazeSolver();

        File directory = new File("examples");
        File[] mazes = directory.listFiles();

        for (File mazeFile : mazes) {
            Maze maze = MazeExtractor.extractMaze(mazeFile.getAbsolutePath());
            logger.info("Maze Dimensions: {}\n", maze.getDimensions());

            String factoredPath = solver.solveMaze(maze);
            logger.info("Factored Path: {}", factoredPath);
            String canonicalPath = MazeUtils.toCanonicalPath(factoredPath);
            logger.info("Canonical Path: {}", canonicalPath);
            String newFactoredPath = MazeUtils.toFactoredPath(canonicalPath);
            logger.info("New Factored Path: {}", newFactoredPath);
            assertEquals(factoredPath, newFactoredPath);
        }
    }

    @Test
    public void testToCanonical() {
        String factoredPath = "5F 3L 2F 4R 5F";
        String noSpaceFactoredPath = "5F3L2F4R5F";
        String canonicalPath = "FFFFF LLL FF RRRR FFFFF";
        String noSpaceCanonicalPath = "FFFFFLLLFFRRRRFFFFF";

        Path path = new Path(factoredPath);

        assertEquals(factoredPath, path.toFactoredForm(true));
        assertEquals(noSpaceFactoredPath, path.toFactoredForm());
        assertEquals(canonicalPath, path.toCanonicalForm(true));
        assertEquals(noSpaceCanonicalPath, path.toCanonicalForm());
    }

    @Test
    public void testToFactored() {
        String canonicalPath = "FFFFF LLL FF RRRR FFFFF";
        String noSpaceCanonicalPath = "FFFFFLLLFFRRRRFFFFF";
        String factoredPath = "5F 3L 2F 4R 5F";
        String noSpaceFactoredPath = "5F3L2F4R5F";

        Path path = new Path(canonicalPath);

        assertEquals(factoredPath, path.toFactoredForm(true));
        assertEquals(noSpaceFactoredPath, path.toFactoredForm());
        assertEquals(canonicalPath, path.toCanonicalForm(true));
        assertEquals(noSpaceCanonicalPath, path.toCanonicalForm());
    }
}

// TODO: Factory pattern - create a maze
// TODO: Maybe talk about chain of responsibility pattern