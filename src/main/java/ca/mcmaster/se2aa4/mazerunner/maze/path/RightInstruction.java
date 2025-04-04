package ca.mcmaster.se2aa4.mazerunner.maze.path;

import ca.mcmaster.se2aa4.mazerunner.maze.MazeWalker;

public class RightInstruction extends PathInstruction {

    @Override
    public boolean execute(MazeWalker walker) {
        // Turn right
        walker.turnRight();
        return true;
    }

    @Override
    public char toCharacter() {
        return 'R';
    }

}
