package stacks_queues.problems;

import java.util.Arrays;
import java.util.Stack;

public class CollidingAsteroid {

    public static int[] collidingAsteroids(int[] asteroids) {
        // Write your code here.
        Stack<Integer> res = new Stack<>();
        for (int num : asteroids) {

            if (res.isEmpty()) {
                res.push(num);
                continue;
            }

            if (num < 0 && res.peek() > 0) {

                if (!res.isEmpty() && Math.abs(num) == res.peek()) {
                    res.pop();
                    continue;
                }

                while (!res.isEmpty() && Math.abs(num) > res.peek() && res.peek() > 0) {
                    res.pop();
                }
                if(Math.abs(num) > res.peek() || res.isEmpty()){
                    res.push(num);
                }



            }else {
                res.push(num);
            }


        }

        int[] result = new int[res.size()];
        int count = result.length;

        while (!res.isEmpty()) {
            result[count - 1] = res.pop();
            count--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inp = {-3, 5, -8, 6, 7, -4, -7};
        System.out.println(Arrays.toString(collidingAsteroids(inp)));
    }
}
