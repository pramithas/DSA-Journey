package recursion.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }

    }

    static boolean solve(int[][] board) {

        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // Iterating through the sudoku board to find the first empty cell.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If the particular cell is empty
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    // This will break the inner loop
                    break;
                }
            }
            // if you found some empty element in row, then break. And, this will break the outer loop.
            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            return true;
            // soduko is solved
        }

        // backtrack in else condition.
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    // found the answer
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }
        // There is an empty cell, where no number from 1-9 can be added. Does this return false value used
        // anywhere? Does it have any significance?
        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    static boolean isSafe(int[][] board, int row, int col, int num) {
        // 1. check the row
        for (int i = 0; i < board.length; i++) {
            // check if the number is in the row
            if (board[row][i] == num) {
                return false;
            }
        }

        // 2. check the col
        for (int[] nums : board) {
            // check if the number is in the col
            if (nums[col] == num) {
                return false;
            }
        }

        // 2. Check inside the cube.
        // Find the start row and col for a random cell.
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}