package arrays.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {

        if(array.length == 0){
            return new ArrayList<Integer>();
        }

        int startRow = 0;
        int startCol = 0;
        int endRow = array.length - 1;
        int endCol = array[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (startRow <= endRow && startCol <= endCol){

            for (int i = startCol; i <= endCol ; i++) {
                result.add(array[startRow][i]);
            }

            if(startRow + 1 > endRow){
                break;
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(array[i][endCol]);
            }

            if(endCol - 1 < startCol){
                break;
            }

            for (int i = endCol - 1; i >= startCol; i--) {
                result.add(array[endRow][i]);
            }

            if(endRow - 1 < startRow){
                break;
            }

            for (int i = endRow - 1; i > startRow; i--) {
                result.add(array[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 2, 5, 4, 7, 6}};
        System.out.println(spiralTraverse(array));
    }
}
