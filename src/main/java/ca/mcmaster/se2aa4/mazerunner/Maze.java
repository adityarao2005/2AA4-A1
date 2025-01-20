package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private CellType[][] maze;

    public Maze(char[][] maze) {
        this.maze = new CellType[maze.length][];

        for (int i = 0; i < maze.length; i++) {
            this.maze[i] = new CellType[maze[i].length];
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == '#') {
                    this.maze[i][j] = CellType.WALL;
                } else if (maze[i][j] == ' ') {
                    this.maze[i][j] = CellType.PASSAGE;
                }
            }
        }

    }

    public Maze(CellType[][] maze) {
        this.maze = maze;
    }

    public CellType getCellType(Position position) {
        return maze[position.getX()][position.getY()];
    }

    public Position getDimensions() {
        return new Position(maze.length, maze[0].length);
    }

    public boolean isWall(Position position) {
        return getCellType(position) == CellType.WALL;
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
            if (!isWall(new Position(0, i))) {
                return new Position(0, i);
            }
        }
        return null;
    }

    public boolean isEndPosition(Position position) {
        return (position.getX() == maze[0].length - 1) && !isWall(position);
    }
}
