package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // Add options
        logger.trace("Starting Maze Runner");
        try {
            // Get file path
            CommandLineProcessor processor = new CommandLineProcessor();

            CommandLine cmdLine = processor.process(args);
            if (!cmdLine.hasOption("i")) {
                logger.error("Missing required option: i");
                System.exit(1);
            }

            // Get the file path
            String filePath = cmdLine.getOptionValue("i");
            System.out.println(cmdLine.getOptionValue("p"));

            // Display the maze
            Maze maze = MazeExtractor.extractMaze(filePath);
            maze.displayMaze();

            logger.info("Computing path");

            // Perform the maze walker if -p is provided
            if (cmdLine.hasOption("p")) {
                // Get the path
                String path = cmdLine.getOptionValue("p");

                MazeWalker walker = new MazeWalker();
                if (walker.verifyPath(maze, path)) {
                    System.out.println("correct path");
                } else {
                    System.out.println("incorrect path");
                }
            } else {
                // Perform maze solver if -p is not provided
                // Use left hand maze solver for now
                MazeSolver solver = new LeftHandMazeSolver();
                String path = solver.solveMaze(maze);
                System.out.println(path);
            }

            logger.trace("End of MazeRunner");
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            e.printStackTrace();
        }
    }
}
