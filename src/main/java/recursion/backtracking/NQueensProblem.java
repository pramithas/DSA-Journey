package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

    public static void main(String[] args) {
        solveNQueens(1);
    }

    public static List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ".";
            }
        }

        List<List<String>> lists = new ArrayList<>();
        queens(board, 0, lists);
        return lists;
    }

    public static int queens(String[][] board, int row, List<List<String>> lists) {

        // Always remember to handle the edge cases.
        if (board.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("Q");
            lists.add(list);
            return 0;
        }

        // All the queen positions have been found.
        if (row == board.length) {
            List<String> innerList = new ArrayList<>();
            for (String[] str : board) {
                StringBuilder inner = new StringBuilder();
                for (String elem : str) {
                    inner.append(elem);
                }
                innerList.add(inner.toString());
            }

            lists.add(innerList);

            return 1;
        }

        int count = 0;

        //placing the queen and checking for every row and col.
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = "Q";
                count += queens(board, row + 1, lists);
                board[row][col] = ".";
            }
        }
        return count;
    }

    private static boolean isSafe(String[][] board, int row, int col) {

        // check up
        for (int i = 0; i < row; i++) {
            if (board[i][col].equalsIgnoreCase("Q")) {
                return false;
            }
        }

        //diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i].equalsIgnoreCase("Q")) {
                return false;
            }
        }

        //diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i].equalsIgnoreCase("Q")) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {

        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

}
