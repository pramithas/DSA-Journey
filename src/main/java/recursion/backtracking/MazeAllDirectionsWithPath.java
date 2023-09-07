package recursion.backtracking;

import java.util.Arrays;

public class MazeAllDirectionsWithPath {

    public static void main(String[] args) {
        boolean maze[][] = {{true, true, true}, {true, true, true}, {true, true, true}};
        int[][] path = new int[maze.length][maze[0].length];
        mazeAllDirectionsWithPath(0, 0, maze, path, 0, "");
    }

    static void mazeAllDirectionsWithPath(int r, int c, boolean maze[][], int[][] path, int step, String processed) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();

            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        // Not just center diagonal. It means diagonal movement from any cell to other cell.
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            mazeAllDirectionsWithPath(r + 1, c + 1, maze, path, step + 1, processed + "A");
        }

        if (c < maze[0].length - 1) {
            mazeAllDirectionsWithPath(r, c + 1, maze, path, step + 1, processed + "R");
        }

        if (r < maze.length - 1) {
            mazeAllDirectionsWithPath(r + 1, c, maze, path, step + 1, processed + "D");
        }

        // for up
        if (r > 0) {
            mazeAllDirectionsWithPath(r - 1, c, maze, path, step + 1, processed + "U");
        }

        // for left
        if (c > 0) {
            mazeAllDirectionsWithPath(r, c - 1, maze, path, step + 1, processed + "L");
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
