package string;

public class CheckPalindrome {
    public static boolean isPalindrome(String str) {

        int firstPointer = 0;
        int lastPointer =  str.length() - 1;

        while(firstPointer <= lastPointer){
            if(str.charAt(firstPointer) != str.charAt(lastPointer)){
                return false;
            }
            firstPointer++;
            lastPointer--;
        }
        return true;
    }
}
