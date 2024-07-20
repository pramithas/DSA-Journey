package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {
    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {

        Set<String> mySet = new HashSet<>(Arrays.asList(words));

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String str : words) {
            ArrayList<String> res = new ArrayList<>();
            String reverse = new StringBuilder(str).reverse().toString();
            if (!reverse.equals(str) && mySet.contains(reverse)) {
                res.add(str);
                res.add(reverse);
                mySet.remove(str);
                mySet.remove(reverse);
            }
            if(!res.isEmpty()){
                result.add(res);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] ip = {"dog", "god"};
        System.out.println(semordnilap(ip));
    }
}
