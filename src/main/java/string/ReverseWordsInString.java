package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInString {
    public static String reverseWordsInString(String string) {

        int n = string.length();
        if(n < 2) return string;

        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        int i, start = 0;

        for (i = 1; i < n; i++){
            char prevChar = string.charAt(i-1), currChar = string.charAt(i);
            if((prevChar == ' ' || currChar == ' ') && (prevChar != currChar)){
                words.add(string.substring(start, i));
                start = i;
            }
        }

        words.add(string.substring(start, i));

        for (int j = words.size() - 1; j >=0 ; j--) {
            sb.append(words.get(j));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString("4   whitespaces"));
    }
}
