package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacters {
    public int firstNonRepeatingCharacter(String string) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return string.indexOf(c);
            }
        }

        return -1;
    }
}
