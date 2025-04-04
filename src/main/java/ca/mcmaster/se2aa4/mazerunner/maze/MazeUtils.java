package ca.mcmaster.se2aa4.mazerunner.maze;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.maze.path.Path;

public class MazeUtils {
    private static final Logger logger = LogManager.getLogger();

    // F - forward, L - left, R - right

    public static String toCanonicalPath(String path) {
        logger.trace("Entering toCanonicalPath method");

        // Create a StringBuilder to store the canonical path
        String canonicalPath = new Path(path).toCanonicalForm();

        logger.trace("Canonical path: " + canonicalPath);
        logger.trace("Exiting toCanonicalPath method");
        // Return the canonical path
        return canonicalPath;

    }

    public static String toFactoredPath(String path) {
        logger.trace("Entering toFactoredPath method");

        // Create a StringBuilder to store the factored path
        String factoredPath = new Path(path).toFactoredForm(true);

        logger.trace("Factored path: " + factoredPath);
        logger.trace("Exiting toFactoredPath method");
        // Return the canonical path
        return factoredPath;
    }

}
