package string;

import java.util.*;

public class CommonCharacters {

    public static String[] commonCharacters(String[] strings) {

        Map<Character, Integer> charCount = new HashMap<>();

        for(String str: strings){
            Set<Character> uniqueChars = new HashSet<>();
            for(char c: str.toCharArray()){
                if(!uniqueChars.contains(c)){
                    charCount.merge(c, 1, Integer::sum);
                    uniqueChars.add(c);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (Character key : charCount.keySet()){
            if(charCount.get(key) == strings.length){
                result.add(""+key);
            }
        }

        return result.toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(commonCharacters(new String[]{"abc", "bcd", "cbaccd"})));
    }
}
