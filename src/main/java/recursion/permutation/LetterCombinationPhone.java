package recursion.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationPhone {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPermuations("9").toArray()));
    }

    public static List<String> findPermuations(String number) {
        List<String> result = new ArrayList<>();

        if (number.isEmpty()) {
            return new ArrayList<>();
        }

        pad("", number, result);
        return result;
    }


    private static void pad(String p, String up, List<String> result) {

        if (up.isEmpty()) {
            result.add(p);
            return;
        }

        // This is just used to calculate the range.
        int digit = up.charAt(0) - '0';

        int start = (digit - 2) * 3;
        int end = (digit - 1) * 3;

        if (digit == 7) {
            end += 1;
        }

        if (digit == 8) {
            start += 1;
            end+=1;
        }

        if (digit == 9) {
            start += 1;
            end+=2;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1), result);
        }
    }
}
