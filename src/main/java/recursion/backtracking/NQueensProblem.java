package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensProblem {

    public static void main(String[] args) {
        displayResult(solveNQueens(6));
    }

    public static List<List<String>> solveNQueens(int n) {

        String[][] board = createBoard(n);
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
            lists.add(prepareResult(board));
            return 1;
        }

        int count = 0;

        //placing the queen and checking for every row and col.
        for (int col = 0; col < board.length; col++) {
            // If safe will always be true for first row.
            if (isSafe(board, row, col)) {
                board[row][col] = "Q";
                count += queens(board, row + 1, lists);
                // Backtracking.
                board[row][col] = ".";
            }
        }
        return count;
    }

    private static List<String> prepareResult(String[][] board) {
        List<String> innerList = new ArrayList<>();
        for (String[] str : board) {
            StringBuilder inner = new StringBuilder();
            for (String elem : str) {
                inner.append(elem);
            }
            // One list for per row.
            innerList.add(inner.toString());
        }

        return innerList;
    }

    private static boolean isSafe(String[][] board, int row, int col) {

        // Need to only check up,left and right. Because, there are no queen below, yet.

        // check up
        for (int i = 0; i < row; i++) {
            if (board[i][col].equalsIgnoreCase("Q")) {
                return false;
            }
        }

        // In both diagonal left and right, the row will decrease, since we are going up. That's why, (row - i)

        //diagonal left
        // The columns to the left is just, col. So, min(row,col)
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i].equalsIgnoreCase("Q")) {
                return false;
            }
        }

        //diagonal right
        // The columns to the right is board.length - col - 1.
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

    private static String[][] createBoard(int n) {

        String[][] board = new String[n][n];

        for (String[] strings : board) {
            Arrays.fill(strings, ".");
        }

        return board;
    }

    private static void displayResult(List<List<String>> result) {

        for(List<String> stringList: result){
            for (String elem: stringList){
                System.out.println(elem);
            }
            System.out.println();
        }

        System.out.println(result.size());
    }

}
