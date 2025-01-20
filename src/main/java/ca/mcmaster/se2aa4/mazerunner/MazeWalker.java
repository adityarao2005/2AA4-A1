package ca.mcmaster.se2aa4.mazerunner;

public class MazeWalker {

    public boolean verifyPath(Maze maze, String path) {
        Direction direction = Direction.RIGHT;
        Position position = maze.getStartPosition();
        // Initialize the direction and position
        for (int i = 0; i < path.length(); i++) {
            // Get the first position
            char c = path.charAt(i);
            // If the character is not a valid character
            if (c == 'L') {
                direction = direction.moveLeft();
            } else if (c == 'R') {
                direction = direction.moveRight();
            } else if (c == 'F') {
                // Move the position
                Position newPosition = position.move(direction);
                // If the new position is a wall
                if (maze.isEndPosition(newPosition)) {
                    return false;
                }
                // Update the position
                position = newPosition;
            }

            if (position.getX() == maze.getDimensions().getX())
                return true;
        }

        // If the path does not reach the end of the maze
        return maze.isEndPosition(position);
    }
}
