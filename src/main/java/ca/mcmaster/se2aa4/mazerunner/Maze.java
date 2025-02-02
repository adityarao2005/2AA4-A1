package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private CellType[][] maze;

    public Maze(char[][] maze) {
        this.maze = new CellType[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++) {
            // Fill the row with the correct CellType
            for (int j = 0; j < maze[i].length; j++) {
                this.maze[i][j] = CellType.fromChar(maze[i][j]);
            }

            // Fill the rest of the row with PASSAGE
            for (int j = maze[i].length; j < this.maze[0].length; j++) {
                this.maze[i][j] = CellType.PASSAGE;
            }
        }

    }

    public Maze(CellType[][] maze) {
        this.maze = maze;
    }

    public CellType getCellType(Position position) {
        return maze[position.getY()][position.getX()];
    }

    public Position getDimensions() {
        return new Position(maze[0].length, maze.length);
    }

    public void displayMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == CellType.WALL) {
                    System.out.print("WALL ");
                } else if (maze[i][j] == CellType.PASSAGE) {
                    System.out.print("PASS ");
                }
            }
            System.out.println();
        }
    }

    public Position getStartPosition() {
        for (int i = 0; i < maze.length; i++) {
            if (!getCellType(new Position(0, i)).isWall()) {
                return new Position(0, i);
            }
        }
        return null;
    }

    public boolean isEndPosition(Position position) {
        return (position.getX() == maze[0].length - 1) && !getCellType(position).isWall();
    }
}
