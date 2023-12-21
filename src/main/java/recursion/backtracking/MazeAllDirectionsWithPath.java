package recursion.backtracking;

import java.util.Arrays;

/**
 * Revised on Dec, 21.
 * This is introduction to backtracking.
 */
public class MazeAllDirectionsWithPath {

    public static void main(String[] args) {
        boolean maze[][] = {{true, true, true}, {true, true, true}, {true, true, true}};
        int[][] path = new int[maze.length][maze[0].length];
        mazeAllDirectionsWithPath(0, 0, maze, path, 0, "");
    }

    static void mazeAllDirectionsWithPath(int r, int c, boolean maze[][], int[][] path, int step, String processed) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {

            path[r][c] = step;

            // Just printing the path.
            // [0, 0, 0]
            // [0, 1, 2]
            // [0, 0, 3]
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();

            return;
        }

        // Step 2: Do not visit the already visited node.
        if (!maze[r][c]) {
            return;
        }

        // Step: 1 Mark the visited node as false, so that it is not visited again.
        maze[r][c] = false;
        // Just tracking that path.
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

        // The value should be reset, before the recursion call returns.
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
