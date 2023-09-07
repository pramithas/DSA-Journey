package recursion.backtracking;

public class MazeAllDirections {

    public static void main(String[] args) {
        boolean maze[][] = {{true, true, true}, {true, true, true}, {true, true, true}};
        mazeAllDirections(0, 0, maze, "");
    }

    static void mazeAllDirections(int r, int c, boolean maze[][], String processed) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        // Not just center diagonal. It means diagonal movement from any cell to other cell.
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            mazeAllDirections(r + 1, c + 1, maze, processed + "A");
        }

        if (c < maze[0].length - 1) {
            mazeAllDirections(r, c + 1, maze, processed + "R");
        }

        if (r < maze.length - 1) {
            mazeAllDirections(r + 1, c, maze, processed + "D");
        }

        // for up
        if (r > 0) {
            mazeAllDirections(r - 1, c, maze, processed + "U");
        }

        // for left
        if (c > 0) {
            mazeAllDirections(r, c - 1, maze, processed + "L");
        }

        maze[r][c] = true;

    }
}
