package arrays.algoexpert;

public class IsMonotonic {
    public static boolean isMonotonic(int[] array) {

        // Write your code here.
        if (array.length == 0 || array.length == 1 || array.length == 2) {
            return true;
        }

        int diff = 0;
        int i = 1;

        for (; i < array.length; i++) {
            if ((array[i] - array[i - 1]) != 0) {
                diff = array[i] - array[i - 1];
                break;
            }
        }

        for (; i < array.length; i++) {

            int newDiff = array[i] - array[i - 1];

            if (newDiff == 0) {
                continue;
            }

            if (Math.signum(newDiff) != Math.signum(diff)) {
                return false;
            }

            diff = newDiff;
        }
        return true;
    }
}
