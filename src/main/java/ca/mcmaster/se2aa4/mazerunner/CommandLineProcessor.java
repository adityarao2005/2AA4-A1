package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandLineProcessor {
    private static final Logger logger = LogManager.getLogger();

    public CommandLine process(String[] args) throws Exception {
        logger.trace("Parsing command line arguments");
        // Create a command line parser
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();

        // Add options
        options.addOption("i", true, "File path");
        options.addOption("p", true, "Check the path");

        // Get the command line options
        try {
            return parser.parse(options, args);
        } finally {
            logger.trace("Finished parsing command line arguments");
        }
    }

}
