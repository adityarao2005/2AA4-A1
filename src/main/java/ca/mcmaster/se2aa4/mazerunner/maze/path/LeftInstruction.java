package ca.mcmaster.se2aa4.mazerunner.maze.path;

import ca.mcmaster.se2aa4.mazerunner.maze.MazeWalker;

public class LeftInstruction extends PathInstruction {
    @Override
    public boolean execute(MazeWalker walker) {
        // Turn right
        walker.turnLeft();
        return true;
    }

    @Override
    public char toCharacter() {
        return 'L';
    }

}
