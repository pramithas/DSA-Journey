package recursion.backtracking;

/**
 * Revised on 21, Dec.
 */
public class MazeWithObstacles {

    public static void main(String[] args) {
        boolean maze[][] = {{true, true, true}, {true, false, false}, {true, true, true}};
        printPathWithObstacles(0, 0, maze, "");
    }

    /**
     * Same as above plus the extra if condition. So, if a cell is blocked just return the recursive call.
     */
    static void printPathWithObstacles(int r, int c, boolean maze[][], String processed) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // Not just center diagonal. It means diagonal movement from any cell to other cell.
//        if (r < maze.length - 1 && c < maze[0].length - 1) {
//            printPathWithObstacles(r + 1, c + 1, maze, processed + "D");
//        }

        if (c < maze[0].length - 1) {
            printPathWithObstacles(r, c + 1, maze, processed + "H");
        }

        if (r < maze.length - 1) {
            printPathWithObstacles(r + 1, c, maze, processed + "V");
        }
    }
}
