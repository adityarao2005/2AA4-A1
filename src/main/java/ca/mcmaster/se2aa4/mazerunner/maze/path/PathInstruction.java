package ca.mcmaster.se2aa4.mazerunner.maze.path;

import ca.mcmaster.se2aa4.mazerunner.maze.MazeWalker;

public abstract class PathInstruction {

    public abstract boolean execute(MazeWalker walker);

    public abstract char toCharacter();

    public static PathInstruction fromCharacter(char c) {
        switch (c) {
            case 'F':
                return new ForwardInstruction();
            case 'L':
                return new LeftInstruction();
            case 'R':
                return new RightInstruction();
            default:
                throw new IllegalArgumentException("Invalid character: " + c);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(toCharacter());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PathInstruction that = (PathInstruction) obj;
        return toCharacter() == that.toCharacter();
    }
}
