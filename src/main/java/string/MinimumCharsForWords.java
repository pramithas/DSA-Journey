package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumCharsForWords {
    public static char[] minimumCharactersForWords(String[] words) {

        Map<Character, Integer> globalMap = new HashMap<>();

        for (String str : words) {
            Map<Character, Integer> charCount = new HashMap<>();

            for (char ch : str.toCharArray()) {
                charCount.merge(ch, 1, Integer::sum);
            }

            for (Character ch : charCount.keySet()) {
                if (globalMap.get(ch) == null) {
                    globalMap.put(ch, charCount.get(ch));
                } else if (globalMap.get(ch) != null && charCount.get(ch) > globalMap.get(ch)) {
                    globalMap.put(ch, charCount.get(ch));
                }
            }
        }

        int sum = 0;

        for (Character ch : globalMap.keySet()) {
            int value = globalMap.get(ch);
            sum += value;
        }

        char[] result = new char[sum];
        int counter = 0;
        for (Character ch : globalMap.keySet()) {
            int value = globalMap.get(ch);
            for (int i = 0; i < value; i++) {
                result[counter++] = ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"this", "that", "did", "deed", "them!", "a"};
        System.out.println(minimumCharactersForWords(words));
    }
}
