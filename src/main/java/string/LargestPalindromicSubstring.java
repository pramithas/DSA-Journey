package string;

public class LargestPalindromicSubstring {

    // abaxyzzyxf
    public static String longestPalindromicSubstring(String str) {

        str = str.trim();

        String longestPalindrome = "";

        for (int i = 0; i < str.length(); i++) {

            StringBuilder tempPalindrome = new StringBuilder();

            tempPalindrome.append(str.charAt(i));

            int left = i - 1;

            int right = i + 1;
            while (left > -1 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                tempPalindrome.insert(0, str.charAt(right));
                tempPalindrome.insert(tempPalindrome.length(), str.charAt(right));
                left--;
                right++;
            }

            if (tempPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = tempPalindrome.toString();
            }

            int current = i;
            left = i - 1;
            tempPalindrome = new StringBuilder();
            while (left > -1 && current < str.length() && str.charAt(left) == str.charAt(current)) {
                tempPalindrome.insert(0, str.charAt(current));
                tempPalindrome.insert(tempPalindrome.length(), str.charAt(current));
                left--;
                current++;
            }

            if (tempPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = tempPalindrome.toString();
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        //System.out.println(longestPalindromicSubstring("it's highnoon"));
        System.out.println(longestPalindromicSubstring("abaxyzyxf"));
        //System.out.println(longestPalindromicSubstring("abba"));
    }
}