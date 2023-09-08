package recursion.backtracking;

public class NKnights {

    public static void main(String[] args) {
        nKnight(4);
    }

    private static void nKnight(int n) {
        boolean[][] board = new boolean[n][n];
        solveNKnight(board, 0, 0, 4);
    }

    private static void solveNKnight(boolean[][] board, int row, int col, int knights) {

        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

//        if (col == board.length) {
//            solveNKnight(board, row + 1, 0, knights);
//            // Have never seen this pattern. i.e. return after recursive method call.
//            return;
//        }

        if (col == board.length) {
            row += 1;
            col = 0;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            solveNKnight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        solveNKnight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Only check the position upper to the current row.
        if (isValid(row - 1, col + 2, board.length)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        if (isValid(row - 2, col + 1, board.length)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(row - 2, col - 1, board.length)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(row - 1, col - 2, board.length)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, int dimension) {
        return row >= 0 && row < dimension && col >= 0 && col < dimension;
    }

    private static void display(boolean[][] board) {

        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
