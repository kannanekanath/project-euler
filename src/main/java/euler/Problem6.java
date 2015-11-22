package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem6 {

    private static long answer(int n) {
        /**
         * If you simply the question the answer is
         *
         * n * n+1 * n-1 * (3n+2) divided by 12
         */
        return (n * (n-1) * (n+1) * ((3 * n) + 2))/ 12;
    }

    public static void main(String[] args) {
        System.out.println(answer(100));
    }
}
