package string;

public class CaeserCypher {

    public static String caesarCypherEncryptor(String str, int key){

        StringBuilder toStore = new StringBuilder();
        int n = str.length();

        for (int i = 0; i < n; i++) {

            int asciiValue = str.charAt(i) + (key % 26);

            if(asciiValue > 'z'){
                asciiValue -= 26;
            }

            toStore.append((char) asciiValue);
        }
        return toStore.toString();
    }

    public static void main(String[] args) {
        caesarCypherEncryptor("zab", 1);
    }
}
