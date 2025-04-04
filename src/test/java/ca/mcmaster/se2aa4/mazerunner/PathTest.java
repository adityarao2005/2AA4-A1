package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeExtractor;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeUtils;
import ca.mcmaster.se2aa4.mazerunner.maze.path.ForwardInstruction;
import ca.mcmaster.se2aa4.mazerunner.maze.path.LeftInstruction;
import ca.mcmaster.se2aa4.mazerunner.maze.path.Path;
import ca.mcmaster.se2aa4.mazerunner.maze.path.PathInstruction;
import ca.mcmaster.se2aa4.mazerunner.maze.path.RightInstruction;
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

    @Test
    public void testPathInstruction() {
        PathInstruction forward = new ForwardInstruction();
        PathInstruction left = new LeftInstruction();
        PathInstruction right = new RightInstruction();

        assertEquals('F', forward.toCharacter());
        assertEquals('L', left.toCharacter());
        assertEquals('R', right.toCharacter());

        assertEquals("F", forward.toString());
        assertEquals("L", left.toString());
        assertEquals("R", right.toString());

    }
}