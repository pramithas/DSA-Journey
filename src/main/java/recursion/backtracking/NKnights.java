package recursion.backtracking;

/**
 * There is a n*n board and we need to place x queens in a way they don't attack each other.
 */
public class NKnights {

    public static void main(String[] args) {
        nKnight(4);
    }

    private static void nKnight(int n) {
        boolean[][] board = new boolean[n][n];
        solveNKnight(board, 0, 0, 4);
    }

    /*
       Knights tracks how much knights are remaining.
     */
    private static void solveNKnight(boolean[][] board, int row, int col, int knights) {

        // all the knights have been placed, so just display the board.
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        // Why?
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            solveNKnight(board, row + 1, 0, knights);
            // Have never seen this pattern. i.e. return after recursive method call.
            return;
        }

//        if (col == board.length) {
//            row += 1;
//            col = 0;
//        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            // is a correct spot is found, try the next column.
            solveNKnight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        // If the current position is not safe, move on to the next column.
        // Why this is not done in NQueen problem.
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
