package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeExtractor;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeWalker;
import ca.mcmaster.se2aa4.mazerunner.solver.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.solver.RightHandMazeSolver;

public class MazeCorrectnessTest {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testPathEquivalence() throws Exception {
        MazeSolver solver = new RightHandMazeSolver();
        MazeWalker walker = new MazeWalker();

        File directory = new File("examples");
        File[] mazes = directory.listFiles();

        for (File mazeFile : mazes) {
            Maze maze = MazeExtractor.extractMaze(mazeFile.getAbsolutePath());
            logger.info("Maze Dimensions: {}\n", maze.getDimensions());

            String path = solver.solveMaze(maze);
            logger.info("Path: {}", path);
            assertTrue(walker.verifyPath(maze, path));
        }
    }

}
