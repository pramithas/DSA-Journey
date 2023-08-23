package recursion.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubset {

    public static void findSubsets(String input) {

        String output = "";

        find(output, input);


    }

    private static void find(String output, String input) {

        if (input.isEmpty()) {
            System.out.print(output);
            return;
        }

        find(output + input.charAt(0), input.substring(1));
        find(output, input.substring(1));
    }

    public static void main(String[] args) {
        findSubsetsAscii("abc");
        //System.out.println(Arrays.toString(result.toArray()));
    }

    public static void findSubsetsV2(String input) {

        String output = "";

        List<String> result = new ArrayList<>();

        findV2(output, input, result);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static void findV2(String output, String input, List<String> result) {

        if (input.isEmpty()) {
            result.add(output);
            return;
        }

        findV2(output + input.charAt(0), input.substring(1), result);
        findV2(output, input.substring(1), result);
    }

    public static List<String> findSubsetsV3(String input) {

        String output = "";

        return findV3(output, input);
    }

    private static List<String> findV3(String output, String input) {

        if (input.isEmpty()) {
            List<String> myList = new ArrayList<>();
            myList.add(output);
            return myList;
        }

        List<String> left = findV3(output + input.charAt(0), input.substring(1));
        List<String> right = findV3(output, input.substring(1));
        left.addAll(right);
        return left;
    }

    public static void findSubsetsAscii(String input) {

        String output = "";

        List<String> result = new ArrayList<>();

        findAscii(output, input, result);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static void findAscii(String output, String input, List<String> result) {

        if (input.isEmpty()) {
            result.add(output);
            return;
        }

        findAscii(output + input.charAt(0), input.substring(1), result);
        findAscii(output, input.substring(1), result);
        findAscii(output + (input.charAt(0)+0), input.substring(1), result);
    }
}
