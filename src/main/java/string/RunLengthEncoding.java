package string;

public class RunLengthEncoding {
    public static String runLengthEncoding(String string) {
        char prev = string.charAt(0);
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < string.toCharArray().length; i++) {
            if (string.charAt(i) == prev) {
                count++;
            } else {
                if(count < 10){
                    result.append(count).append(prev);
                }else {
                    while (count > 0){

                        if(count > 9){
                            result.append(9).append(prev);
                        }else {
                            result.append(count).append(prev);
                        }
                        count-=9;
                    }
                }

                count = 1;
            }
            if(count > 9){
                result.append(9).append(prev);
            }else {
                result.append(count).append(prev);
            }
            prev = string.charAt(i);
        }

        result.append(count).append(prev);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("************^^^^^^^$$$$$$%%%%%%%!!!!!!AAAAAAAAAAAAAAAAAAAA"));
    }
}
