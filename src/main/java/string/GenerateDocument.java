package string;

import java.util.HashMap;
import java.util.Map;
public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c: characters.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(char c: document.toCharArray()){
            // THE KEY DOES NOT EXISTS OR THE COUNT OF KEYS IS NOT ENOUGH.
            if(!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(generateDocument("Bste!hetsi ogEAxpelrt x ","AlgoExpert is the Best"));
        System.out.println(generateDocument("aheaollabbhb","hello"));
    }
}
