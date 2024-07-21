package string;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {

        List<String> sortedList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : words) {
            sortedList.add(sort(str));
        }

        Set<String> processed = new HashSet<>();
        for (String str : words) {
            List<String> intermediateRes = new ArrayList<>();
            for (int i = 0; i < sortedList.size(); i++) {
                if (sort(str).equals(sortedList.get(i))) {
                    if (!processed.contains(words.get(i))) {
                        processed.add(words.get(i));
                        intermediateRes.add(words.get(i));
                    }
                }
            }

            if (!intermediateRes.isEmpty()) {
                result.add(intermediateRes);
            }
        }
        return result;
    }

    private static String sort(String inp) {
        char[] toSort = inp.toCharArray();
        Arrays.sort(toSort);
        return new String(toSort);
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")));
    }
}
