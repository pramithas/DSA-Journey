package arrays.algoexpert;

public class TransposeMatrix {

    public int[][] transposeMatrix(int[][] matrix) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] result = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Just doing will do the trick.
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
