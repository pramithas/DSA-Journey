package bitwise;

public class FindIthBit {

    public static int ithBit(int input, int i){
        return (input & (1 << i));
    }

    public static void main(String[] args) {
        int input = 411;
        int ans = ithBit(input, 3);
        System.out.println(ans);
    }
}
