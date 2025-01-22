package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeUtils {
    private static final Logger logger = LogManager.getLogger();

    // F - forward, L - left, R - right

    public static String toCanonicalPath(String path) {
        logger.trace("Entering toCanonicalPath method");

        // Create a StringBuilder to store the canonical path
        StringBuilder builder = new StringBuilder();

        // Iterate through the path string
        int number = -1;
        for (int i = 0; i < path.length(); i++) {
            char current = path.charAt(i);
            // If the character is a digit, store it in the number variable
            if (Character.isDigit(current)) {
                number = Character.getNumericValue(path.charAt(i));
                // If the character is an F, L, or R, append it to the builder
            } else if (current != ' ') {
                // If the number variable is greater than 0, append the character to the builder
                // that many times
                if (number > 0) {
                    for (int j = 0; j < number; j++) {
                        builder.append(path.charAt(i));
                    }
                    number = -1;
                } else {
                    // If the number variable is not greater than 0, append the character to the
                    // builder
                    builder.append(path.charAt(i));
                }
            }
        }

        String canonicalPath = builder.toString();

        logger.trace("Canonical path: " + canonicalPath);
        logger.trace("Exiting toCanonicalPath method");
        // Return the canonical path
        return canonicalPath;

    }

    public static String toFactoredPath(String path) {
        logger.trace("Entering toFactoredPath method");

        // Create a StringBuilder to store the factored path
        StringBuilder builder = new StringBuilder();
        // Create a variable to store the current character
        char current = path.charAt(0);
        int count = 1;

        // Iterate through the path string
        for (int i = 1; i < path.length(); i++) {
            // If the character is the same as the current character, increment the number
            // variable
            if (path.charAt(i) == current) {
                count++;
                // If the character is a space, skip it
            } else if (current != ' ') {
                // If the character is different from the current character, append the current
                if (count > 1)
                    builder.append(count);
                builder.append(current);
                current = path.charAt(i);
                count = 1;
            }
        }

        // Add the last character
        if (count > 1)
            builder.append(count);
        builder.append(current);

        String factoredPath = builder.toString();

        logger.trace("Factored path: " + factoredPath);
        logger.trace("Exiting toFactoredPath method");
        // Return the canonical path
        return factoredPath;
    }

}
