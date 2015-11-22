package euler;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Problem18 {

    private static final String INPUT = "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    private static final String SMALL_INPUT = "3\n" +
            "7 4\n" +
            "2 4 6\n" +
            "8 5 9 3";

    public static void main(String[] args) {
        System.out.println(solution(read2dArray(new StringReader(INPUT))));
    }

    private static long solution(int[][] array) {
        int[][] sumArray = new int[array.length][];
        sumArray[0] = new int[]{array[0][0]};
        for (int i = 1; i < array.length; i++) {
            sumArray[i] = new int[array[i].length];
            sumArray[i][0] = sumArray[i-1][0] + array[i][0];
            int maxIndex = array[i].length - 1;
            for (int j = 1; j < maxIndex; j++) {
                sumArray[i][j] = Math.max(sumArray[i-1][j-1], sumArray[i-1][j]) + array[i][j];
            }
            sumArray[i][maxIndex] = sumArray[i-1][maxIndex-1] + array[i][maxIndex];
        }
        return Arrays.stream(sumArray[sumArray.length-1]).max().getAsInt();
    }
    private static void print2dArray(int[][] array) {
        Stream.of(array).flatMap(Stream::of).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    private static int[][] read2dArray(Reader input) {
        return new BufferedReader(input).lines().map(Problem18::convertLine).toArray(int[][]::new);
    }

    private static int[] convertLine(String line) {
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
