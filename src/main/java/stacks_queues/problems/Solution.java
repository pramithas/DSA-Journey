package stacks_queues.problems;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacks(maxSum, a, b, 0, 0);
    }

    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {

        if (sum > maxSum) {
            return count - 1;
        }

        if (a.size() == 0 || b.size() == 0) {
            return count;
        }

        int first = twoStacks(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count + 1);
        int second = twoStacks(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count + 1);

        return Math.max(first, second);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int maxSum = Integer.parseInt(firstMultipleInput[2]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

                int result = Result.twoStacks(maxSum, a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();

//        int counts = twoStacks(60, Arrays.asList(17, 5, 0), Arrays.asList(10, 8, 2, 1, 13, 1, 14, 18, 16, 19, 5));
//        System.out.println(counts);
    }
}
