package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeExtractor {
    private static final Logger logger = LogManager.getLogger();

    public static Maze extractMaze(String filePath) throws Exception {
        logger.trace("Entering extractMaze");
        logger.info("Reading file: " + filePath);

        // Read maze from file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[][] mazeArr = reader
                // Get the lines in the file
                .lines()
                // Map each line to a character array
                .map(String::toCharArray)
                // Convert the stream to an array of character arrays
                .toArray(char[][]::new);

        reader.close();

        Maze maze = new Maze(mazeArr);
        logger.trace("Exiting extractMaze");
        return maze;
    }
}
