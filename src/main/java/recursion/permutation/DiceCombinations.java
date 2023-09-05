package recursion.permutation;

public class DiceCombinations {

    public static void main(String[] args) {
        System.out.println(dice(4, 6));
    }

    public static int dice(int target, int k) {
        int count = 0;
        return solve(target, k, "", count);
    }

    static int solve(int target, int k, String processed, int count) {

        int finalCount = 0;

        if (target == 0) {
            return 1;
        }

        for (int i = 1; i <= k && i <= target; i++) {
            finalCount += solve(target - i, k, (processed + i), count);
        }
        return finalCount;
    }
}
