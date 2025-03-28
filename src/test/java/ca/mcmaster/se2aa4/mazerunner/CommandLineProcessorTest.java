package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.Test;

public class CommandLineProcessorTest {

    @Test
    public void testCommandLineArgs() throws Exception {
        CommandLineProcessor processor = new CommandLineProcessor();
        String file = "examples/maze1.txt";
        String[] args = { "-i", file, "-p", "path" };
        CommandLine cmdLine = processor.process(args);

        assertTrue(cmdLine.hasOption("i"));
        assertEquals(cmdLine.getOptionValue("i"), file);
        assertTrue(cmdLine.hasOption("p"));
        assertEquals(cmdLine.getOptionValue("p"), "path");
    }

    @Test
    public void testCommandLineArgsNoPath() throws Exception {
        CommandLineProcessor processor = new CommandLineProcessor();
        String file = "examples/maze1.txt";
        String[] args = { "-i", file };
        CommandLine cmdLine = processor.process(args);

        assertTrue(cmdLine.hasOption("i"));
        assertEquals(cmdLine.getOptionValue("i"), file);
        assertFalse(cmdLine.hasOption("p"));
    }

}
