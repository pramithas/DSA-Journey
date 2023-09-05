package recursion.backtracking;

public class Maze {

    public static void main(String[] args) {
        printPath(3, 3, "");
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;
    }

    static void printPath(int r, int c, String processed) {

        if (r == 1 && c == 1) {
            System.out.println(processed);
            return;
        }

        // Not just center diagonal. It means diagonal movement from any cell to other cell.
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
