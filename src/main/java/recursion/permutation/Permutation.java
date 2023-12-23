package recursion.permutation;

/**
 * Revised on dec 22, 2023.
 */
public class Permutation {

    public static void main(String[] args) {
        findPermutations("abc");
    }

    private static void findPermutations(String input) {

        calculatePermutations("", input);
    }

    private static void calculatePermutations(String processed, String input) {

        if (input.isEmpty()) {
            System.out.println(processed);
            return;
        }

        int length = processed.length();

        for (int i = 0; i < length + 1; i++) {
            // This is the formula to calculate processed.
            String processedNew = processed.substring(0, i) + input.charAt(0) + processed.substring(i, length);
            calculatePermutations(processedNew, input.substring(1));
        }
    }
}
