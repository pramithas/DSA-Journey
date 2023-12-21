package recursion.backtracking;

/**
 * Revised on Dec 21, 2023.
 */
public class Maze {

    public static void main(String[] args) {
        printPath(2, 2, "");
    }

    /**
     * Counts the nummber of paths.
     * @param r
     * @param c
     * @return
     */
    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int down = count(r - 1, c);
        int right = count(r, c - 1);

        return down + right;
    }

    /**
     * Displays the path from source to goal.
     * @param r
     * @param c
     * @param processed
     */
    static void printPath(int r, int c, String processed) {

        if (r == 1 && c == 1) {
            System.out.println(processed);
            return;
        }

        // Not just central diagonal. It means diagonal movement from any cell to other cell.
        if (r > 1 && c > 1) {
            printPath(r - 1, c - 1, processed + "D");
        }

        if (c > 1) {
            printPath(r, c - 1, processed + "H");
        }

        if (r > 1) {
            printPath(r - 1, c, processed + "V");
        }
    }
}
