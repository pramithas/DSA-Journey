package recursion.subsequence;

/**
 * Revised dec 21, 2023.
 */
public class RemoveAChar {

    public static void main(String[] args) {
        String input = "bacca";
        System.out.println(removeCharV2(input));

    }

    private static String removeChar(String input) {

        String ans = "";
        return remove(input, ans);
    }

    private static String remove(String input, String ans) {

        if (input.length() == 0) {
            return ans;
        }

        if (input.charAt(0) == 'a') {
        } else {
            ans += input.charAt(0);
        }
        return remove(input.substring(1), ans);
    }

    private static String removeCharV2(String input) {

        if (input.isEmpty()) {
            return "";
        }

        char ch = input.charAt(0);

        if (ch == 'a') {
            return removeCharV2(input.substring(1));
        } else {
            return ch + removeCharV2(input.substring(1));
        }
    }
}
